package cn.stanliski.offer51.BitManipulation;

/**
 * 
 * Swap odd even bits.
 * 
 * @author stanley_hwang
 *
 */
public class SwapOddEvenBits {
	
	/**
	 * swap odd even bits.
	 * @param x
	 * @return
	 */
	public int swapOddEvenBits(int x){
		int left = (x & 0xaaaaaaaa) >> 1;
		int right = (x & 0x55555555) << 1;
		return left | right;
	}
	
	public static void main(String args[]){
		int x = 7;
		SwapOddEvenBits swap = new SwapOddEvenBits();
		int result = swap.swapOddEvenBits(x);
		System.out.println(result);
	}
	
}
