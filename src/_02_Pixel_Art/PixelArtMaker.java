package _02_Pixel_Art;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JFrame;

import _05_Serialization.SaveData;

public class PixelArtMaker implements MouseListener{
	private static JFrame window;
	private GridInputPanel gip;
	public static GridPanel gp;
	static ColorSelectionPanel csp;
	
	public void start() {
		gip = new GridInputPanel(this);	
		window = new JFrame("Pixel Art");
		window.setLayout(new FlowLayout());
		window.setResizable(false);
		
		window.add(gip);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void submitGridData(int w, int h, int r, int c) {
		gp = new GridPanel(w, h, r, c);
		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		gp.repaint();
		gp.addMouseListener(this);
		window.pack();
	}
	
	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	private static final String DATA_FILE = "src/_02_Pixel_Art/pixelSaved.dat";

	public static void save(GridPanel data) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void load() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); ObjectInputStream ois = new ObjectInputStream(fis)) {
			window.remove(gp);
			GridPanel gp2 = (GridPanel) ois.readObject();
			gp = gp2;
			window.add(gp);
			window.remove(csp);
			window.add(csp);
			window.pack();
			gp.repaint();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
