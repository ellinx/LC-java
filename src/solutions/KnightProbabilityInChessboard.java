package solutions;

/**
On an NxN chessboard, a knight starts at the r-th row and c-th column and 
attempts to make exactly K moves. The rows and columns are 0 indexed, 
so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. 
Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random 
(even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. 
Return the probability that the knight remains on the board after it has stopped moving.


Example:

Input: 3, 2, 0, 0
Output: 0.0625
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.
 

Note:
1. N will be between 1 and 25.
2. K will be between 0 and 100.
3. The knight always initially starts on the board.
 */

public class KnightProbabilityInChessboard {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        double[][] board = new double[N][N];
        board[r][c] = 1.0;
        for (int m=0;m<K;m++) {
            double[][] next = new double[N][N];
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    if (board[i][j]>0) {
                        for (int[] each:dirs) {
                            int ni = i+each[0];
                            int nj = j+each[1];
                            if (ni>=0 && ni<N && nj>=0 && nj<N) {
                                next[ni][nj] += board[i][j]/8.0;
                            }
                        }
                    }
                }
            }
            board = next;
        }
        double ret = 0.0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                ret += board[i][j];
            }
        }
        return ret;
    }
}
