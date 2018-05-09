package ellinx.solutions;


public class NumberOfIslands {
	/**
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. An island is surrounded by water and is formed by connecting
	 * adjacent lands horizontally or vertically. You may assume all four edges of
	 * the grid are all surrounded by water.
	 * 
	 * Example 1:
	 * 
	 * 11110 
	 * 11010 
	 * 11000 
	 * 00000 
	 * Answer: 1
	 * 
	 * Example 2:
	 * 
	 * 11000 
	 * 11000 
	 * 00100 
	 * 00011 
	 * Answer: 3
	 * 
	 *
	 */
	public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m==0)
            return 0;
        
        int n = grid[0].length;
        int[] roots = new int[m*n];
        int count = 0;
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]=='1') {
                    roots[i*n+j] = i*n+j;
                    count++;
                } else {
                    roots[i*n+j] = -1;
                }
            }
        }
        
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (grid[i][j]=='1') {
                    //up
                    if (i>0 && grid[i-1][j]=='1') {
                        int rootA = getRoot(i*n+j, roots);
                        int rootB = getRoot((i-1)*n+j, roots);
                        if (rootA!=rootB){
                            roots[rootA] = rootB;
                            count--;
                        }
                    }
                    //down
                    if (i<m-1 && grid[i+1][j]=='1') {
                        int rootA = getRoot(i*n+j, roots);
                        int rootB = getRoot((i+1)*n+j, roots);
                        if (rootA!=rootB){
                            roots[rootA] = rootB;
                            count--;
                        }
                    }
                    //left
                    if (j>0 && grid[i][j-1]=='1') {
                        int rootA = getRoot(i*n+j, roots);
                        int rootB = getRoot(i*n+j-1, roots);
                        if (rootA!=rootB){
                            roots[rootA] = rootB;
                            count--;
                        }
                    }
                    //right
                    if (j<n-1 && grid[i][j+1]=='1') {
                        int rootA = getRoot(i*n+j, roots);
                        int rootB = getRoot(i*n+j+1, roots);
                        if (rootA!=rootB){
                            roots[rootA] = rootB;
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
    
    private int getRoot(int node, int[] roots) {
        while (roots[node]!=node) {
            node = roots[node];
        }
        return node;
    }
    
    //test 
    public static void main(String[] args) {
    	NumberOfIslands noi = new NumberOfIslands();
    	char[][] grid = {
    			{'1','1','1','1','0'},
    			{'1','1','0','1','0'},
    			{'1','1','0','0','0'},
    			{'0','0','0','0','0'}
    	};
    	int result = noi.numIslands(grid);
    	System.out.println(result);
	}
}
