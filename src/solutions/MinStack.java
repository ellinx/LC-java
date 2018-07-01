package solutions;

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
    Stack<Integer> stkVals;
    Stack<Integer> stkMins;
    
    /** initialize your data structure here. */
    public MinStack() {
        stkVals = new Stack<>();
        stkMins = new Stack<>();
    }
    
    public void push(int x) {
        stkVals.push(x);
        if (stkMins.isEmpty() || x<=stkMins.peek()) {
            stkMins.push(x);
        }
    }
    
    public void pop() {
        int temp = stkVals.pop();
        if (stkMins.peek()==temp) {
            stkMins.pop();
        }
    }
    
    public int top() {
        return stkVals.peek();
    }
    
    public int getMin() {
        return stkMins.peek();
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
