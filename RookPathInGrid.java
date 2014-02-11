import java.util.Arrays;


public class RookPathInGrid {
	
	//4x4 grid has 5x5 corners. 
	//default value initialization.
	 private int cornerArrSize = 8;
	 private int rows = 8;
	 private int cols = 8;
	
	 private int getTotalRobotPaths(boolean[][] grid, int x, int y){
		
		boolean[][] copyGrid = deepCopy(grid);
		
		//making sure the indices do not cause array index of bounds exception.
		if(x >=0 && x < rows && y>= 0 && y < cols){
			copyGrid[x][y] = true;
		}else{
			return 0;
		}
		//if the point is already traversed then it is not a valid path.
		if(grid[x][y]){
			return 0;
		}
		
		//we have reached to the bottom-right corner of grid from a path so return one.
		if(x == (rows -1) && y == (cols-1 )){
			return 1;
		}
		//sum of all possible paths from top, bottom, left and right.
		return getTotalRobotPaths(copyGrid, x+1, y) + getTotalRobotPaths(copyGrid, x, y+1) + getTotalRobotPaths(copyGrid, x-1, y) + getTotalRobotPaths(copyGrid, x, y-1);   
		
	}
	 //Since the java clone doesn't deep copy and it is always advised not to use it.
	private boolean[][] deepCopy(boolean[][] original) {
	    if (original == null) {
	        return null;
	    }

	    boolean[][] result = new boolean[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	        // For Java versions prior to Java 6 use the next:
	        // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
	    }
	    return result;
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
		System.out.println(tpc.getTotalRobotPaths(4,3));
	}

}
