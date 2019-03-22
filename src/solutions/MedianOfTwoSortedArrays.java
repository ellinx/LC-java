package solutions;

/**
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));
        int m = nums1.length;
        int n = nums2.length;
        if (m==0) {
            if (n%2==1) {
                return nums2[n/2];
            }
            return (nums2[(n-1)/2]+nums2[n/2])/2.0;
        }
        int l=0, r=m;
        while (l<r) {
            // System.out.println("l="+l+","+"r="+r);
            int mid = l+(r-l)/2;
            int i=mid, j=(m+n)/2-mid;
            // System.out.println(i+","+j);
            if (i-1>=0 && nums1[i-1]>nums2[j]) {
                r = mid-1;
            } else if (i<m && nums2[j-1]>nums1[i]) {
                l = mid+1;
            } else {
                l = mid;
                break;
            }
        }
        int i = l;
        int j = (m+n)/2-l;
        // System.out.print("--"+i+","+j);
        if ((m+n)%2==1) {
            if (i==m) {
                return nums2[j]/1.0;
            }
            return Math.min(nums1[i], nums2[j])/1.0;
        }
        int left = 0;
        if (i-1>=0 && j-1>=0) {
            left = Math.max(nums1[i-1], nums2[j-1]);
        } else if (i-1>=0) {
            left = nums1[i-1];
        } else {
            left = nums2[j-1];
        }
        int right = 0;
        if (i<m && j<n) {
            right = Math.min(nums1[i], nums2[j]);
        } else if (i<m) {
            right = nums1[i];
        } else {
            right = nums2[j];
        }
        return (left+right)/2.0;
    }
}
