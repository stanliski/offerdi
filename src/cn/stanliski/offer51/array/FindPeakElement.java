package cn.stanliski.offer51.array;

/**
 * 
 * Find Peak Element. 
 * 
 * @author stanley_hwang
 *
 */
public class FindPeakElement {

	/**
	 * Find peak element.
	 * @param num
	 * @return
	 */
	public int findPeakElement(int[] num) {
		if(num == null || num.length == 0)
			return -1;
		int low = 0;
		int high = num.length - 1;
		while(low < high){
			int mid = (low + high) / 2;
			int rear = mid + 1;
			if(num[rear] > num[mid]){
				low = rear;
			}else{
				high = mid;
			}
		}
		return low;
	}

	/**
	 * The time complexity is O(n).
	 * @param num
	 * @return
	 */
	public int findPeakElementBySeq(int[] num){
		if(num == null || num.length == 0)
			return -1;
		for(int i = 1; i < num.length; i++){
			if(num[i] < num[i-1]){
				return i-1;
			}
		}
		return num.length-1;
	}

	public static void main(String args[]){
		int[] num = new int[]{1,3,1,2,5,1,2};
		FindPeakElement peak = new FindPeakElement();
		int data = peak.findPeakElementBySeq(num);
		System.out.println("Peak number = " + num[data]);
	}

}
