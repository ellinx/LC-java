package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ...,
 * N-1.
 * 
 * When a student enters the room, they must sit in the seat that maximizes the
 * distance to the closest person. If there are multiple such seats, they sit in
 * the seat with the lowest number. (Also, if no one is in the room, then the
 * student sits at seat number 0.)
 * 
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat()
 * returning an int representing what seat the student sat in, and
 * ExamRoom.leave(int p) representing that the student in seat number p now
 * leaves the room. It is guaranteed that any calls to ExamRoom.leave(p) have a
 * student sitting in seat p.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * ["ExamRoom","seat","seat","seat","seat","leave","seat"],
 * [[10],[],[],[],[],[4],[]] 
 * 
 * Output: [null,0,9,4,2,null,5] 
 * Explanation:
 * ExamRoom(10) -> null 
 * seat() -> 0, no one is in the room, then the student sits at seat number 0. 
 * seat() -> 9, the student sits at the last seat number 9. 
 * seat() -> 4, the student sits at the last seat number 4. 
 * seat() -> 2, the student sits at the last seat number 2. 
 * leave(4) -> null 
 * seat() -> 5, the student​​​​​​​ sits at the last seat number 5.
 * 
 * ​​​​​​​
 * 
 * Note:
 * 
 * 1 <= N <= 10^9 
 * ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases. 
 * Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 * 
 * 
 * @author Ellinx
 *
 */
public class ExamRoom {
    private List<Integer> seated;
    private int N;
    
    public ExamRoom(int N) {
        seated = new ArrayList<>();
        this.N = N;
    }
    
    public int seat() {
        if (seated.isEmpty()) {
            seated.add(0);
            return 0;
        }
        int[] pos_dist_index = new int[3];
        for (int i=1;i<seated.size();i++) {
            int dist = (seated.get(i)-seated.get(i-1))/2;
            if (dist>pos_dist_index[1]) {
                pos_dist_index = new int[]{seated.get(i-1)+dist, dist, i};
            }
        }
        if (seated.get(0)>=pos_dist_index[1]) {
            pos_dist_index = new int[]{0, seated.get(0), 0};
        }
        if (N-1-seated.get(seated.size()-1)>pos_dist_index[1]) {
            pos_dist_index = new int[]{N-1, N-1-seated.get(seated.size()-1), seated.size()};
        }
        seated.add(pos_dist_index[2], pos_dist_index[0]);
        return pos_dist_index[0];
    }
    
    public void leave(int p) {
        int start = 0;
        int end = seated.size()-1;
        while (start<=end) {
            int mid = start+(end-start)/2;
            if (seated.get(mid)==p) {
                seated.remove(mid);
                return;
            }
            if (seated.get(mid)<p) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
    }
    

	/**
	 * Your ExamRoom object will be instantiated and called as such:
	 * ExamRoom obj = new ExamRoom(N);
	 * int param_1 = obj.seat();
	 * obj.leave(p);
	 */
}
