/**
 * 
 */
package cn.stanliski.offer51.math;

/**
 * 
 * Copyright  2015 EMC Corporation 
 * All Rights Reserved 
 * 
 * This software contains the intellectual property of EMC Corporation 
 * or is licensed to EMC Corporation from third parties.  Use of this 
 * software and the intellectual property contained therein is expressly 
 * limited to the terms and conditions of the License Agreement under which 
 * it is provided by or on behalf of EMC. 
 *
 */

public class SequenceNumberSum {
	
	public void sequenceNumberSum(int n){
		
		int small = 1;
		int big = 2;
		int curSum = small + big;
		int end = (1 + n) / 2;
		while(small < end){
			if(curSum == n)
				printSequence(small, big);
			while(curSum > n && small < end){
				curSum -= small;
				++small;
				if(curSum == n){
					printSequence(small, big);
				}
			}
			big++;
			curSum += big;
		}
	}
	
	public void printSequence(int start, int end){
		for(int i = start;  i <= end; i++){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		SequenceNumberSum sns = new SequenceNumberSum();
		sns.sequenceNumberSum(100);
	}
	
}
