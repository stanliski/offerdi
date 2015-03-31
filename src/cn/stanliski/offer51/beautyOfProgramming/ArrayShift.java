package cn.stanliski.offer51.beautyOfProgramming;

/**
 * 
 * Array shift
 * @author stanley_hwang
 *
 */
public class ArrayShift {
	
	public void reverse(int[] array, int low, int high){
		while(low < high){
			int temp = array[low];
			array[low] = array[high];
			array[high] = temp;
			low++;
			high--;
		}
	}
	
	public void rightShiftII(int[] array, int k){
		k %= array.length;
		int n = array.length;
		reverse(array, 0, n-k-1);
		reverse(array, n-k, n-1);
		reverse(array, 0, n-1);
	}
	
	/**
	 * 
	 * Right shift.
	 * 
	 * @param array
	 * @param n
	 * @param k
	 */
	public void rightShift(int[] array, int n, int k){
		k %= n;
		while(k > 0){
			int t = array[n-1];
			for(int i = n-1; i > 0; i--){
				array[i] = array[i-1];
			}
			array[0] = t;
			k--;
		}
	}
		
	public static void main(String args[]){
		int[] data = new int[]{1,2,3,4,5,6};
		int k = 9;
		ArrayShift shift = new ArrayShift();
		shift.rightShiftII(data, k);
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + " ");
	}
	
}
