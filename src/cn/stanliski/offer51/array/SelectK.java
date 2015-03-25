package cn.stanliski.offer51.array;

/**
 * Select K 算法
 * @author stanley_hwang
 *
 */
public class SelectK {
	
	public int partitionII(int[] array, int lo, int hi){
		int i = lo, j = hi;
		while(i <= j){
			while(i < j  && array[i] < array[lo])
				i++;
			if(i == hi)
				break;
			while(i < j  && array[j] > array[lo])
				if(j == lo)
					break;
			if(lo >= hi)
				break;
			swap(array, i, j);
		}
		swap(array, i, j);
		return j;
	}
	
	private void quickSort(int[] array, int lo, int hi){
		if(lo >= hi)
			return;
		int index = partitionII(array, lo, hi);
		quickSort(array, lo, index-1);
		quickSort(array, index+1, hi);
	}
	
	
	public int partition(int[] array, int left, int right, int pivot){
		while(true){
			while(left <= right && array[left] <= pivot){
				left++;
			}
			while(left <= right && array[right] > pivot){
				right--;
			}
			if(left > right)
				return left-1;
			swap(array, left, right);
		}
	}
	
	public int partitionIII(int[] array, int left, int right, int pivot){
		while(left < right){
			while(left < right && array[right] >= pivot)
				right--;
			array[left] = array[right];
			while(left < right && array[left] > pivot)
				left++;
			array[right] = array[left];
		}
		array[left] = pivot;
		return left-1;
	}

	public void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public int randomIntInRange(int left, int right){
		return (int)(left + Math.random() * (right-left));
	}
	
	public int max(int[] array, int left, int right){
		int max = Integer.MIN_VALUE;
		for(int i = left; i <= right; i++){
			if(max < array[i]){
				max = array[i];
			}
		}
		return max;
	}
	
	public int rank(int[] array, int left, int right, int rank){
		int pivot = array[randomIntInRange(left, right)];
		int leftEnd = partition(array, left, right, pivot);
		int leftSize = leftEnd - left + 1;
		if(leftSize == rank + 1)
			return max(array, left, leftEnd);
		else if(rank < leftSize)
			return rank(array, left, leftEnd, rank);
		else
			return rank(array, leftEnd+1, right, rank-leftSize);
	}
	
	public static void main(String args[]){
//		int array[] = new int[]{9,3,2,4,8};
//		SelectK s = new SelectK();
//		int target = s.rank(array, 0, array.length-1, 3);
//		System.out.println(target);
//		s.quickSort(array, 0, array.length-1);
//		for(int i = 0; i < array.length; i++)
//			System.out.print(array[i] + " ");
		System.out.println((int)(1 + Math.random()*3));
	}
	
}
