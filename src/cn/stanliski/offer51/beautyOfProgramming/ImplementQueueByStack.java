package cn.stanliski.offer51.beautyOfProgramming;

import java.util.Stack;

public class ImplementQueueByStack{
	
	private Stack<Integer> stackA = new Stack<Integer>();
	private Stack<Integer> stackB = new Stack<Integer>();
	
	public int dequeue(){
		shift();
		return stackB.pop();
	}
	
	public void shift(){
		if(stackB.isEmpty()){
			while(!stackA.isEmpty()){
				stackB.push(stackA.pop());
			}
		}
	}
	
	public void enqueue(int ele){
		stackA.push(ele);
	}
	
}
