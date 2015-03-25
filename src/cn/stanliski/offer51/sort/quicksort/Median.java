package cn.stanliski.offer51.sort.quicksort;

/**
 * Median.
 * @author stanley_hwang
 *
 */
public class Median {

	
	 public int partition(int[] nums, int low, int high, int pivot){
		 while(true){
			 while(low <= high && nums[low] <= pivot)
				 low ++;
			 while(low <= high && nums[high] > pivot)
				 high--;
			 if(low > high)
				 return low - 1;
			 swap(nums, low, high);
		 }
	 }
	 
	 public void swap(int[] nums, int low, int high){
		 int temp = nums[low];
		 nums[low] = nums[high];
		 nums[high] = temp;
	 }
	 
	 public int median(int[] nums) {
		 if(nums == null || nums.length == 0)
			 return -1;
		 return medianHelper(nums, 0, nums.length-1, (nums.length/2));
	 }
	 
	 public int max(int nums[], int low, int high){
		 int max = Integer.MIN_VALUE;
		 for(int i = low; i <= high; i++){
			 if(max < nums[i]){
				 max = nums[i];
			 }
		 }
		 return max;
	 }
	 
	 public int medianHelper(int[] nums, int low, int high, int rank){
		 int pivot = (int)(low + Math.random()*(high-low));
		 int leftEnd = partition(nums, low, high, pivot);
		 int size = leftEnd - low + 1;
		 if(size == rank + 1){
			 return max(nums, low, size);
		 }else if(size > rank){
			 return medianHelper(nums, low, leftEnd, rank);
		 }else
			 return medianHelper(nums, leftEnd+1, high, rank-size);
	 }
	 
	 public static void main(String args[]){
		 int nums[] = new int[]{9,3,2,4,8};
		 Median m = new Median();
		 int med = m.median(nums);
		 System.out.println(med);
	 }
}
