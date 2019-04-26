package solutions;

import java.util.Arrays;

/**
You have 4 cards each containing a number from 1 to 9. 
You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24

Example 2:
Input: [1, 2, 1, 2]
Output: False

Note:
1. The division operator / represents real division, not integer division. 
	For example, 4 / (1 - 2/3) = 12.
2. Every operation done is between two numbers. 
	In particular, we cannot use - as a unary operator. 
	For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
3. You cannot concatenate numbers together. 
	For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */

public class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        double[] dnums = new double[4];
        for (int i=0;i<4;i++) {
            dnums[i] = nums[i];
        }
        return judgePoint24(dnums);
    }

    private boolean judgePoint24(double[] dnums) {
        if (dnums.length==1) {
            //System.out.println(Arrays.toString(nums));
            if (Math.abs(24.0-dnums[0])<0.0001) {
                return true;
            }
            return false;
        }
        double[] nums = Arrays.copyOf(dnums, dnums.length);
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int i=0;i<nums.length;i++) {
            if (i>0 && nums[i-1]==nums[i]) {
                continue;
            }
            for (int j=i+1;j<nums.length;j++) {
                if (j>i+1 && nums[j-1]==nums[j]) {
                    continue;
                }
                double[] next = new double[nums.length-1];
                int idx = 0;
                for (int k=0;k<next.length-1;k++) {
                    while (idx==i || idx==j) {
                        idx++;
                    }
                    next[k] = nums[idx];
                    idx++;
                }
                idx = next.length-1;
                //System.out.println(i+","+j+","+idx+"---"+Arrays.toString(next));
                //plus
                next[idx] = nums[i]+nums[j];
                if (judgePoint24(next)) {
                    return true;
                }
                //minus
                next[idx] = nums[i]-nums[j];
                //System.out.println(Arrays.toString(next));
                if (judgePoint24(next)) {
                    return true;
                }
                next[idx] = nums[j]-nums[i];
                if (judgePoint24(next)) {
                    return true;
                }
                //multiply
                next[idx] = nums[i]*nums[j];
                if (judgePoint24(next)) {
                    return true;
                }
                //divide
                if (nums[j]!=0) {
                    next[idx] = nums[i]/nums[j];
                    if (judgePoint24(next)) {
                        return true;
                    }
                }
                if (nums[i]!=0) {
                    next[idx] = nums[j]/nums[i];
                    if (judgePoint24(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
