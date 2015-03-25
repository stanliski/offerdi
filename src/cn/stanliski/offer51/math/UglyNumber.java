package cn.stanliski.offer51.math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Ugly Number.
 * 
 * @author huangs14
 *
 */
public class UglyNumber {

	/**
	 * Use more space to reduce time cost.
	 * @param k
	 * @return
	 */
	public int getKthUglyNumber(int k){
		if(k < 0)
			return 0;
		int val = 0;
		Queue<Integer> queue3 = new LinkedList<Integer>();
		Queue<Integer> queue5 = new LinkedList<Integer>();
		Queue<Integer> queue7 = new LinkedList<Integer>();
	    queue3.add(1);
 		for(int i = 0; i <= k; i++){
 			int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE;
 			int v5 = queue5.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
 			int v7 = queue7.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;
 			val = Math.min(v3, Math.min(v5, v7));
 			if(val == v3){
 				queue3.remove();
 				queue3.add(3 * val);
 				queue3.add(5 * val);
 			}else if(val == v5){
 				queue5.remove();
 				queue5.add(5 * val);
 			}else if(val == v7)
 				queue7.remove();
 			queue7.add(val * 7);
 		}
		return val;
	}
	
	public boolean isUglyNumber(int number){
		
		while(number % 2 != 0){
			number /= 2;
		}
		
		while(number % 3 != 0){
			number /= 3;
		}
		
		while(number % 5 != 0){
			number /= 5;
		}
		return (number == 1) ? true : false;

	}
	
	public int getUglyNumber(int index){
		if(index < 0)
			return 0;
		int number = 0;
		int count = 0;
		while(count < index){
			++number;
			if(isUglyNumber(number)){
				++count;
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		UglyNumber un = new UglyNumber();
		int count = un.getKthUglyNumber(1);
		System.out.println("kth ugly number:" + count);
	}
	
}
