package cn.stanliski.offer51.sort;

/**
 * 
 * Quick sort.
 * @author stanley_hwang
 *
 */
public class QuickSort {
	
	public int partition(int[] data, int start, int end){
		if(data == null)
			return -1;
		if(start > end)
			return -1;
		int index = (int)(start + Math.random()*(end - start));
		swap(data, index, end);
		int small = start - 1;
		for(index = start; index < end; ++index){
			if(data[index] < data[end]){
				++small;
				if(small != index)
					swap(data, index, small);
			}
		}
		++small;
		swap(data, small, end);
		return small;
	}
	
	public void quickSort(int data[], int start, int end){
		if(start == end)
			return;
		int index = partition(data, start, end);
		if(index > start)
			quickSort(data, start, index-1);
		if(index < end)
			quickSort(data, index+1, end);
	}
	
	public void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String args[]){
		int[] data = new int[]{3,1,2,4,7,5};
		QuickSort qs = new QuickSort();
		qs.quickSort(data, 0, data.length-1);
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
	}
	
}
