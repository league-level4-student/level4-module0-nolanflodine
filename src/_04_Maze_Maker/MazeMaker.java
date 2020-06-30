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
		selectNextPath(c[r1][r2]);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		//A. mark cell as visited
		c[r1][r2].hasBeenVisited();
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		
 		//C. if has unvisited neighbors,
		//ArrayList<Cell> n = getUnvisitedNeighbors(currentCell);
		if(getUnvisitedNeighbors(currentCell).size()>0) {
			//C1. select one at random.
			r1 = randGen.nextInt(getUnvisitedNeighbors(currentCell).size());
			r2 = randGen.nextInt(getUnvisitedNeighbors(currentCell).size());
			//C2. push it to the stack
		uncheckedCells.push(c[r1][r2]);
			//C3. remove the wall between the two cells
			removeWalls(c[r1][r2], currentCell);
			//C4. make the new cell the current cell and mark it as visited
		currentCell = c[r1][r2];
		currentCell.hasBeenVisited();
			//C5. call the selectNextPath method with the current cell
		selectNextPath(currentCell);
		}
			
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

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		if(c1.getX()+100==c2.getX()||c1.getX()-100==c2.getX()||c1.getY()+100==c2.getY()||c1.getY()-100==c2.getY()) { // checks if they are adjacent I think
		}
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {  
		return null;
	}
}
