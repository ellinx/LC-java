package solutions;

import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth
 * largest element in the sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2 
 * Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4 
 * Output: 4
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Ellinx
 *
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<nums.length;i++) {
            pq.offer(nums[i]);
            if (pq.size()==k+1) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    
    //quick sort
    public int findKthLargest2(int[] nums, int k) {
        return helper(nums, 0, nums.length-1, k);
    }
    
    private int helper(int[] nums, int s, int e, int k) {
        if (s==e) {
            return nums[s];
        }
        int pivot = nums[s];
        int l = s+1;
        int r = e;
        while (l<=r) {
            if (nums[l]>=pivot) {
                l++;
            } else {
                int temp = nums[r];
                nums[r] = nums[l];
                r--;
                nums[l] = temp;
            }
        }
        if (l==k) {
            return pivot;
        }
        if (l>s+1) {
            int temp = nums[s];
            nums[s] = nums[l-1];
            nums[l-1] = temp;
        }
        //System.out.println(Arrays.toString(nums)+",pivot="+pivot+",l="+l+"r="+r+",k="+k);
        if (k<l) {
            return helper(nums, s, l-2, k);
        }
        return helper(nums, l, e, k);
    }
}
