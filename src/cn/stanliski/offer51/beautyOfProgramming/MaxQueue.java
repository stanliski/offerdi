package cn.stanliski.offer51.beautyOfProgramming;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxQueue {
	
	Comparator<Integer> comparator = new Comparator<Integer>(){
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 < o2)
				return 1;
			else if(o1 > o2)
				return -1;
			return 0;
		}
	};
 	
	private PriorityQueue<Integer> heap = new PriorityQueue<Integer>(3, comparator);
	
	private Queue<Integer> queue = new ArrayDeque<Integer>();
	
	int max = Integer.MIN_VALUE;
	
	public void enqueue(int data){
		queue.add(data);
		heap.add(data);
	}
	
	public int dequeue(){
		int data = queue.poll();
		return data;
	}
	
	public int max(){
		return heap.peek();
	}
	
	public static void main(String args[]){
		int[] data = new int[]{4,2,1,8,9,4};
		MaxQueue queue = new MaxQueue();
		for(int i = 0; i < data.length; i++){
			queue.enqueue(data[i]);
		}
		System.out.println(queue.max());
	}
	
}
