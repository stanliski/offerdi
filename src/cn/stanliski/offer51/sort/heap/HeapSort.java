package cn.stanliski.offer51.sort.heap;

/**
 * 
 * Heap sort.
 * @author stanley_hwang
 *
 */
public class HeapSort {

	int data[] = new int[10];
	
	int N = 10;
	
	private void swim(int k){
		while(k > 1 && data[k] > data[k / 2]){
			swap(data, k, k/2);
			k = k / 2;
		}
	}

	/**
	 * 1.去左右子节点中，稍大的那个元素做比较
	 * 2.如果父节点比这个较大的元素还大，表示满足要求，退出
	 * 3.否则，与子节点进行交换
	 * @param k
	 */
	private void sink(int[] data, int k, int N){
		while(2 * k < N){
			int j = 2 * k;
			if(data[j] < data[j+1]) 
				j++;
			if(data[k] > data[j])
				break;
			swap(data, k, j);
			k = j;
		}
	}
	
	public void heapSort(int[] data){
		int len = data.length;
		for(int k = len/2-1; k >= 0; k--){
			sink(data, k, len);
		}
		
		while(N > 1){
			swap(data, 0, N--);
			sink(data, 0, N);
		}
		
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
	}
	
	public static void main(String args[]){
		int N = 10;
		int[] data = new int[N];
		for(int i = 0; i < N; i++){
			data[i] = (int) (Math.random() * 100); 
		}
		HeapSort hs = new HeapSort();
		hs.heapSort(data);
	}
	
	private void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	
}	
