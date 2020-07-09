package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker extends Maze{
	
	public MazeMaker(int w, int h) {
		super(w, h);
		// TODO Auto-generated constructor stub
	}

	private static int width;
	private static int height;
	static int r1;
	static int r2;
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		Random r = new Random();
		 r1 = r.nextInt(width);
		 r2 = r.nextInt(height);
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.getCell(r1, r2));
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		EnterExit(maze.getCell(0, 1), maze.getCell(width-1, 4));
		System.out.println("x"+currentCell.getX());
		System.out.println("y"+currentCell.getY());
		maze.getCell(currentCell.getX(),currentCell.getY()).setBeenVisited(true);
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> n = getUnvisitedNeighbors(currentCell);
 		//C. if has unvisited neighbors,
		if(n.size()>0) {
			//C1. select one at random.
			r1 = randGen.nextInt(n.size());
			Cell cel = n.get(r1);
			//C2. push it to the stack
		uncheckedCells.push(cel);
			//C3. remove the wall between the two cells
			removeWalls(cel, currentCell);
			
			//C4. make the new cell the current cell and mark it as visited
		currentCell = cel;
		currentCell.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
		selectNextPath(currentCell);
		}
		else {
			
		//D. if all neighbors are visited
		if(getUnvisitedNeighbors(currentCell).size()==0) {
			//D1. if the stack is not empty
			if(uncheckedCells.size()>0) {
				// D1a. pop a cell from the stack
					Cell p = uncheckedCells.pop();
				// D1b. make that the current cell
					currentCell = p;
				// D1c. call the selectNextPath method with the current cell
					selectNextPath(p);
			}
		}
		}
			
		
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void EnterExit(Cell c1, Cell c2) {
		c1.setWestWall(false);
		c2.setEastWall(false);
	}
	
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX()+1==c2.getX()&&c1.getY()==c2.getY()) {
			c1.setEastWall(false);
			c2.setWestWall(false);
		}
		if(c1.getX()-1==c2.getX()&&c1.getY()==c2.getY()) {
			c1.setWestWall(false);
			c2.setEastWall(false);
		}
		if(c1.getY()+1==c2.getY()&&c1.getX()==c2.getX()) {
			c1.setSouthWall(false);
			c2.setNorthWall(false);
		}
		if(c1.getY()-1==c2.getY()&&c1.getX()==c2.getX()) {
			c1.setNorthWall(false);
			c2.setSouthWall(false);
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {  
		ArrayList<Cell> n = new ArrayList<Cell>();
		if(c.getX()+1<maze.getWidth()&&!maze.getCell(c.getX()+1, c.getY()).hasBeenVisited()) {
			n.add(maze.getCell(c.getX()+1, c.getY()));
			//System.out.println("hello");
		}
		if(c.getX()>0&&!maze.getCell(c.getX()-1, c.getY()).hasBeenVisited()) {
			n.add(maze.getCell(c.getX()-1, c.getY()));
		}
		if(c.getY()+1<maze.getHeight()&&!maze.getCell(c.getX(), c.getY()+1).hasBeenVisited()) {
			n.add(maze.getCell(c.getX(), c.getY()+1));
		}
		if(c.getY()>0&&!maze.getCell(c.getX(), c.getY()-1).hasBeenVisited()) {
			n.add(maze.getCell(c.getX(), c.getY()-1));
		}
		return n;
	}
}
