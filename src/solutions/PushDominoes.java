package solutions;

/**
 * There are N dominoes in a line, and we place each domino vertically upright.
 * 
 * In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
 * After each second, each domino that is falling to the left pushes the adjacent domino on the left.
 * Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
 * When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
 * For the purposes of this question, we will consider that a falling domino expends no additional force to a falling
 * or already fallen domino.
 * Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; 
 * S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.

 * Return a string representing the final state. 

 * Example 1:
 * Input: ".L.R...LR..L.."
 * Output: "LL.RR.LLRRLL.."
 * 
 * Example 2:
 * Input: "RR.L"
 * Output: "RR.L"
 * Explanation: The first domino expends no additional force on the second domino.
 * 
 * Note:
 * 0 <= N <= 10^5
 * String dominoes contains only 'L', 'R' and '.'
 * 
 * @author Ellinx
 *
 */
public class PushDominoes {
	public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        while (end<dominoes.length()) {
            if (dominoes.charAt(end)=='.') {
                end++;
                continue;
            }
            if (dominoes.charAt(end)=='L') {
                if (dominoes.charAt(start)=='L' || dominoes.charAt(start)=='.') {
                    for (int i=0;i<end+1-start;i++) {
                        sb.append('L');
                    }
                    start = ++end;
                } else {
                    for (int i=0;i<(end+1-start)/2;i++) {
                        sb.append('R');
                    }
                    if ((end+1-start)%2==1) {
                        sb.append('.');
                    }
                    for (int i=0;i<(end+1-start)/2;i++) {
                        sb.append('L');
                    }
                    start = ++end;
                }
            } else {
                if (dominoes.charAt(start)=='L' || dominoes.charAt(start)=='.') {
                    sb.append(dominoes.charAt(start));
                    for (int i=0;i<end-1-start;i++) {
                        sb.append('.');
                    }
                    start = end++;
                } else {
                    for (int i=0;i<end-start;i++) {
                        sb.append('R');
                    }
                    start = end++;
                }
            }
        }
        if (start<dominoes.length()) {
            if (dominoes.charAt(start)=='L' || dominoes.charAt(start)=='.') {
                sb.append(dominoes.charAt(start));
                for (int i=0;i<end-1-start;i++) {
                    sb.append('.');
                }
            } else {
                for (int i=0;i<end-start;i++) {
                    sb.append('R');
                }
            }
        }
        return sb.toString();
    }
}
