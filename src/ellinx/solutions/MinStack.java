package ellinx.solutions;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. 
 * pop() -- Removes the element on top of the stack. 
 * top() -- Get the top element. 
 * getMin() -- Retrieve the minimum element in the stack. 
 * 
 * Example: 
 * MinStack minStack = new MinStack();
 * minStack.push(-2); 
 * minStack.push(0); 
 * minStack.push(-3); 
 * minStack.getMin(); --> Returns -3. 
 * minStack.pop(); 
 * minStack.top(); --> Returns 0.
 * minStack.getMin(); --> Returns -2.
 * 
 * @author Ellinx
 *
 */
public class MinStack {
	private Stack<Integer> stack;
    private PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        pq = new PriorityQueue<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        pq.add(x);
    }
    
    public void pop() {
        int value = stack.pop();
        pq.remove(value);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    
    //test
    public static void main(String[] args) {
    	 MinStack minStack = new MinStack();
    	 minStack.push(-2); 
    	 minStack.push(0); 
    	 minStack.push(-3); 
    	 System.out.println(minStack.getMin()); // --> Returns -3. 
    	 minStack.pop(); 
    	 System.out.println(minStack.top()); //--> Returns 0.
    	 System.out.println(minStack.getMin()); //--> Returns -2.
	}
}
