package cn.stanliski.offer51.binarySearch;

/**
 * 
 * Get number of K.
 * @author stanley_hwang
 *
 */
public class GetNumberOfK {
	
	public int getFirstK(int[] array, int lo, int hi, int k){
		if(lo > hi)
			return -1;
		int mid = (hi + lo) >> 1;
		int data = array[mid];
		if(data == k){
			if((mid > 0 && array[mid-1] != k) || mid == 0)
				return mid;
			else 
				hi = mid-1;
		}else if(data < k){
			lo = mid + 1;
		}else{
			hi = mid - 1;
		}
		return getFirstK(array, lo, hi, k);
	}
	
	public int getLastK(int[] array, int lo, int hi, int k){
		if(lo > hi)
			return -1;
		int mid = (hi + lo) >> 1;
		int data = array[mid];
		if(data == k){
			if((mid < hi && array[mid+1] != k) || mid == hi){
				return mid;
			}else{
				lo = mid + 1;
			}
		}else if(data < k){
			lo = mid + 1;
		}else 
			hi = mid - 1;
		return getLastK(array, lo, hi, k);
	}
	
	public int getNumberOfK(int[] array, int k){
		if(array == null || array.length == 0)
			return -1;
		int start = getFirstK(array, 0, array.length-1, k);
		int end = getLastK(array, 0, array.length-1, k);
		int rst = 0;
		if(start > -1 && end > -1){
			rst = end - start + 1;
		}
		return rst;
	}
	
	public static void main(String args[]){
		int[] number = new int[]{1,2,2,2,3,4,5};
		GetNumberOfK k = new GetNumberOfK();
		int rst = k.getNumberOfK(number, 2);
		System.out.println(rst);
	}
	
}
