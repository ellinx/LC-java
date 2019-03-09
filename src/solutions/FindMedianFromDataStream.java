package solutions;

import java.util.Collections;
import java.util.PriorityQueue;

/**
Median is the middle value in an ordered integer list. 
If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
 

Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
 

Follow up:
1. If all integer numbers from the stream are between 0 and 100, how would you optimize it?
2. If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    private int size;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
        size = 0;
    }
    
    public void addNum(int num) {
        if (size%2==1) {
            if (num<left.peek()) {
                left.offer(num);
                num = left.poll();
                right.offer(num);
            } else {
                right.offer(num);
            }
        } else {
            if (size==0) {
                left.offer(num);
            } else if (num>right.peek()) {
                right.offer(num);
                num = right.poll();
                left.offer(num);
            } else {
                left.offer(num);
            }
        }
        size++;
    }
    
    public double findMedian() {
        if (size%2==1) {
            return left.peek();
        }
        return (left.peek()+right.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
