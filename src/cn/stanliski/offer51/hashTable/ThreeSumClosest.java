package cn.stanliski.offer51.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Three sum closest.
 * @author stanley_hwang
 *
 */
public class ThreeSumClosest {

	private int closest;
	
	private boolean needInit;

	public int threeSumClosest(int[] num, int target) {
		closest = 0;
		needInit = true;
		Arrays.sort(num);
		
		int i = 0;
		for (i = 0; i <= num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}
			judgeAndPut(num, i, i + 1, num.length - 1, target);
		}
		return closest;
	}

	private void judgeAndPut(int[] num, int i, int p, int q, int target) {

		while (p < q) {
			int sum = num[i] + num[p] + num[q];
			if (needInit || Math.abs(sum - target) < Math.abs(closest - target)) {
				closest = sum;
			}
			needInit = false;

			if (sum <= target) {
				p++;
				while (p < q && num[p] == num[p - 1]) {
					p++;
				}
			} else if (sum > target){
				q--;
				while (p < q && num[q] == num[q + 1]) {
					q--;
				}
			}
		}

	}
	
	public static void main(String args[]){
		int[] numbers = new int[]{-1,2,1,-4};
		ThreeSumClosest closest = new ThreeSumClosest();
		closest.threeSumClosest(numbers, 1);
	}

	public Comparator compare = new Comparator(){

		public int compare(Object o1, Object o2) {
			ArrayList<Integer> arr1 = (ArrayList<Integer>)o1;
			ArrayList<Integer> arr2 = (ArrayList<Integer>)o2;
			int i = 0;
			while(i < 3){
				if(arr1.get(i) < arr2.get(i))
					return 1;
				else if(arr1.get(i) == arr2.get(i))
					i++;
				else
					return -1;
			}
			return 0;
		}

	};

}
