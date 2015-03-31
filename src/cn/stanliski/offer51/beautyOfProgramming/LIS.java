package cn.stanliski.offer51.beautyOfProgramming;

/**
 * Longest increase sequence
 * @author stanley_hwang
 *
 */
public class LIS {

	
	public int lis(int[] array){
		int n = array.length;
		int lis[] = new int[array.length];
		for(int i = 0; i < n; i++){
			lis[i] = 1;
			for(int j = 0; j < i; j++){
				if(array[i] > array[j] && lis[j] + 1 > lis[i])
					lis[i] = lis[j] + 1;
			}
		}
		return max(lis);
	}
	
	public int max(int[] lis){
		int max = 0;
		for(int i = 0; i < lis.length; i++){
			if(max < lis[i])
				max = lis[i];
		}
		return max;
	}
	
	public static void main(String args[]){
		int[] data = new int[]{1,-1,2,-3,4,-5,6,7};
		LIS lis = new LIS();
		int max = lis.lis(data);
		System.out.println(max);
	}
	
}	
