import java.util.Arrays;


public class RookPathInGrid {
	
	
	//default value initialization.
	//This is the case for a chess board.
	 private int cornerArrSize = 8;
	 private int rows = 8;
	 private int cols = 8;
	
	 private int getTotalRobotPaths(boolean[][] grid, int x, int y){
		int total;

		//making sure the indices do not cause array index of bounds exception.
		if(x >=0 && x < rows && y>= 0 && y < cols){
			//if the point is already traversed then it is not a valid path.	
			if(grid[x][y]){
				return 0;
			}
			grid[x][y] = true;
		}else{
			return 0;
		}
		
		
		//we have reached to the bottom-right corner of grid from a path so return one.
		if(x == (rows -1) && y == (cols-1 )){
			//backtracking.
			//we set the current location to false and return such
			//that while recursing this location can be reached from another path.
			grid[x][y] = false;
			return 1;
		}
		
		//sum of all possible paths from top, bottom, left and right.
		total = getTotalRobotPaths(grid, x+1, y) + getTotalRobotPaths(grid, x, y+1) + getTotalRobotPaths(grid, x-1, y) + getTotalRobotPaths(grid, x, y-1);
		//backtracking.
		grid[x][y] = false;
		return total;
		
	}
	
	//helper function which helps users with a easy to use interface 
	//and hiding all the implementation details.
	public int getTotalRobotPaths(int gridSize) {
		if(gridSize<1){
			throw new IllegalArgumentException();
		}
		this.rows = gridSize;
		this.cols =gridSize;
		return getTotalRobotPaths(new boolean[rows][cols], 0, 0);
	}
	public int getTotalRobotPaths(int rows, int cols) {
		if(rows <1 || cols < 1){
			throw new IllegalArgumentException();
		}
		this.rows = rows;
		this.cols = cols;
		return getTotalRobotPaths(new boolean[rows][cols], 0, 0);
	}
	
	public static void main(String args[]){
		RookPathInGrid tpc = new RookPathInGrid();
		System.out.println(tpc.getTotalRobotPaths(4,4));
	}

}
