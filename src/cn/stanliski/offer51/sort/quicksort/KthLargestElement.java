package cn.stanliski.offer51.sort.quicksort;

import java.util.ArrayList;

/**
 * 
 * Kth Largest Element
 * @author stanley_hwang
 *
 */
public class KthLargestElement {
	
	//param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
    	if(numbers == null && numbers.size() == 0)
    		return -1;
    	int nums[] = new int[numbers.size()];
    	for(int i = 0; i < numbers.size(); i++)
    		nums[i] = numbers.get(i);
    	return kthLargestElement(k, 0, nums.length-1, nums);
    }
	
	public int partition(int data[], int left, int right, int pivot){
		while(true){
			while(left <= right && data[left] <= pivot)
				left++;
			while(left <= right && data[right] > pivot)
				right--;
			if(left > right)
				return left-1;
			swap(data, left, right);
		}
	}
	
	public int partitionII(int data[], int low, int high){
		if(low > high)
			return -1;
		int index = (int)(low + Math.random()*(high-low));
		swap(data, index, high);
		int small = low-1;
		for(index = low; index < high; ++index){
			if(data[index] < data[high]){
				++small;
				if(small != index){
					swap(data, small, index);
				}
			}
		}
		++small;
		swap(data, small, high);
		return small;
	}

	 //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, int left, int right, int[] array) {
    	int pivot = array[(int)(left + Math.random()*(right-left))];
    	int leftEnd = partition(array, left, right, pivot);
    	int leftSize = leftEnd - left + 1;
    	if(leftSize == k + 1){
    		int max = Integer.MIN_VALUE;
    		for(int i = left; i <= leftEnd; i++){
    			if(array[i] > max){
    				max = array[i];
    			}
    		}
    		return max;
    	}else if(leftSize > k){
    		return kthLargestElement(k, left, leftEnd, array);
    	}else{
    		return kthLargestElement(k-leftSize, leftEnd+1, right, array);
    	}
    }
	
	public void swap(int data[], int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
	public static void main(String args[]){
		int data[] = new int[]{5,6,8,9,10,7};
		int num = 4;
		KthLargestElement k = new KthLargestElement();
		int rst = k.kthLargestElement(2, 0, data.length-1, data);
		System.out.println(rst);
	}
	
}
