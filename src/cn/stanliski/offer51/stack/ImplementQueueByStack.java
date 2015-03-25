package cn.stanliski.offer51.stack;

import java.util.Stack;

/**
 * 
 * Implement Queue By Stack.
 * 
 * @author stanley_hwang
 *
 */
public class ImplementQueueByStack {

	private Stack<Integer> stack1;
	
	private Stack<Integer> stack2;

	public ImplementQueueByStack() {
		// do initialization if necessary
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int element) {
		stack1.push(element);
	}

	public void shiftStack(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}

	public int pop() {
		shiftStack();
		return stack2.pop();
	}

	public int top() {
		shiftStack();
		return stack2.peek();
	}

}
