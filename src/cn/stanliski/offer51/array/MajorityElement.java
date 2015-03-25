package cn.stanliski.offer51.array;

import java.util.ArrayList;

/**
 * 
 * Majority Element.
 * 
 * @author stanley_hwang
 *
 */
public class MajorityElement {

	/**
	 * Majority Number.
	 * @param nums
	 * @return
	 */
	public int majorityNumber(ArrayList<Integer> nums) {
		// write your code
		if(nums == null || nums.size() == 0)
			return -1;
		int count = 0;
		int index = nums.get(0);
		for(Integer num : nums){
			if(num == index)
				count++;
			else{
				count--;
				if(count == 0){
					index = num;
					count = 1;
				}
			}
		}
		if(count > nums.size()/2)
			return index;
		else 
			return -1;
	}

	/**
	 * Find Majority Element.
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		if(num == null || num.length == 0)
			return -1;
		int count = 1;
		int majorityElement = num[0];
		for(int i = 1; i < num.length; i++){

			if(majorityElement == num[i])
				count++;
			else{
				count--;
				if(count == 0){
					majorityElement = num[i];
					count = 1;
				}
			}
		}
		return majorityElement;
	}

	public static void main(String args[]){
		//[1,1,1,1,2,2,2]
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(1);
		nums.add(1);
		nums.add(1);
		nums.add(1);
		nums.add(2);
		nums.add(2);
		nums.add(2);
		MajorityElement me = new MajorityElement();
		char c = 'A';
		System.out.println(me.majorityNumber(nums));
	}

}
