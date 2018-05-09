package ellinx.solutions;

/**
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
 * 
 * You receive a valid board, made of only battleships or empty slots.
 * Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
 * At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
 * Example:
 * X..X
 * ...X
 * ...X
 * In the above board there are 2 battleships.
 * Invalid Example:
 * ...X
 * XXXX
 * ...X
 * This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
 * Follow up:
 * Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 * @author Ellinx
 *
 */
public class BattleshipsInBoard {
	public int countBattleships(char[][] board) {
		int res = 0;
        for (int i=0 ;i<board.length;i++) {
        	for (int j=0;j<board[i].length;j++) {
        		if (board[i][j]=='X') {        			
        			markBattleShip(i, j, board);
        			res++;
        		}
        	}
        }
        return res;
    }
	
	private void markBattleShip(int row, int col, char[][] board) {
		int m = row;
		int n = col;
		//check vertically only down

		while (row+1<board.length && board[row+1][col]=='X') {
			board[row+1][col] = '.';
			row++;
		}

		//check horizontally only right
		row = m;
		col = n;
		while (col+1<board[row].length && board[row][col+1]=='X') {
			board[row][col+1] = '.';
			col++;
		}
		
		//mark ontiginal point
		board[m][n] = '.';
	}
	
	// test
	public static void main(String[] args) {
		BattleshipsInBoard BIB = new BattleshipsInBoard();
		char[][] board = {
				{'X','.',',','X'},
				{'.','.','.','X'},
				{'.','.','.','X'}
		};
		int result = BIB.countBattleships(board);
		System.out.println(result);
	}
}
