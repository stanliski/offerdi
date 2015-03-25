package cn.stanliski.offer51.array;

/**
 * 
 * Remove Duplicates from sorted array.
 * 
 * @author stanley_hwang
 *
 */
public class RemoveDuplicatesfromSortedArray {

	/**
	 * 
	 * Time Complexity is O(n).
	 * 
	 * @param A
	 * @return
	 */
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0)
			return 0;
		int i = 0;
		int j = i+1;
		while(j < A.length){
			if(A[i] != A[j]){
				++i;
				if(i != j){
					swap(A, i, j);
				}
			}
			j++;
		}
		return i+1;
	}
	
	public int removeDuplicatesIII(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[size]){
                size++;
                nums[size] = nums[i];
            }
        }
        return size+1;
    }

	/**
	 * 
	 * Remove Duplicates II.
	 * 
	 * @param A
	 * @return
	 */
	public int removeDuplicatesII(int[] A){
		if (A == null || A.length == 0) return 0;  
		int startPosition = 0;  
		boolean isRepeated = false;  
		for (int i = 1; i < A.length; i++) {  
			if (A[i] != A[startPosition]) {  
				isRepeated = false;  
				startPosition++;  
				A[startPosition] = A[i];  
			} else {  
				if (isRepeated == false) {  
					startPosition++;  
					A[startPosition] = A[i];  
					isRepeated = true;  
				}  
			}  
		}  
		return startPosition + 1;  
	}

	/**
	 * Swap the elements in the array.
	 * @param A
	 * @param i
	 * @param j
	 */
	public void swap(int[] A, int i, int j){
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String args[]){
		int[] array = new int[]{1,1,2};
		RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
		System.out.println(test.removeDuplicates(array));
	}

}
