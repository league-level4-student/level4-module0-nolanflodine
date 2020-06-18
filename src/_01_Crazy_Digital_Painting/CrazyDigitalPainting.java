package _01_Crazy_Digital_Painting;

import java.awt.Color;
import java.util.Random;

public class CrazyDigitalPainting extends ColorArrayDisplayer{
	//1. Create two final static integers for the width and height of the display.
final static int width = 1000;
final static int height = 600;
	
	static //2. Create a 2D array of Color objects. You will need to import
	//java.awt.Color. Initialize the size of the array using the 
	//integers created in step 1.
	Color[][] color = new Color[width][height];
	
	
	public CrazyDigitalPainting() {
		//3. Open the crazy_digital_painting.png file and look at the image.
		//okay
		//4. Iterate through the 2D array and initialize each Color object
		//   to a new color. The sample image was created using the following 
		//   pattern:
		//   colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		Random r = new Random();
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < color[i].length; j++) {
				color[i][j] = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			}
		}
		//5. Come up with your own pattern to make a cool crazy image.
		
		//6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method 
		//   to show off your picture.
	}
	
	public static void main(String[] args) {
		 new CrazyDigitalPainting();
		 CrazyDigitalPainting.displayColorsAsImage(color);
	}
}
