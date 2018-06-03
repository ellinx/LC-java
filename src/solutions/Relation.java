package solutions;

public class Relation {
	//matrix[i][j] is one if i knows j
	private int[][] matrix;

	public void setRelation(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public boolean knows(int i, int j) {
		return matrix[i][j]==1;
	}
	
}
