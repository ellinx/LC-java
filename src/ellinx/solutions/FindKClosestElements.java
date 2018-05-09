package ellinx.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x
 * in the array. The result should also be sorted in ascending order. If there
 * is a tie, the smaller elements are always preferred.
 * 
 * Example 1: 
 * Input: [1,2,3,4,5], k=4, x=3 
 * Output: [1,2,3,4] 
 * 
 * Example 2: 
 * Input: [1,2,3,4,5], k=4, x=-1 
 * Output: [1,2,3,4] 
 * 
 * Note: 
 * 1. The value k is positive and will always be smaller than the length of the 
 * 	  sorted array. 
 * 2. Length of the given array is positive and will not exceed 104 
 * 3. Absolute value of elements in the array and x will not exceed 104
 * 
 * @author Ellinx
 *
 */
public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = arr.length-k;
        
        while(start < end) {
            int mid = start + (end-start)/2;
            if (x-arr[mid] > arr[mid+k]-x) {
                start = mid+1;
            } else {
                end = mid;
            }
        }
        
        for (int i=0;i<k;i++) {
            res.add(arr[start+i]);
        }
        return res;
    }
	
	//test
	public static void main(String[] args) {
		FindKClosestElements fce = new FindKClosestElements();
		int[] arr = {1,2,3,4,5};
		List<Integer> result = fce.findClosestElements(arr, 4, 3);
		System.out.println(result);
	}
}
