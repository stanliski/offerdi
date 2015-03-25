package cn.stanliski.offer51.BitManipulation;

/**
 * the bit swap steps from number A to number B;
 * @author stanley_hwang
 *
 */
public class BitNumberSwap {

	public int bitSwapRequiredByMe(int a, int b){
		int count = 0;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(b));
		for(int i = a^b; i != 0; i &= (i-1)){
			count++;
		}
		return count;
	}
	
	
	public int bitSwapRequired(int a, int b){
		int count = 0;
		for(int i = a^b; i != 0; i &= (i-1)){
			count++;
		}
		return count;
	}
	
	public int bitSwapRequiredII(int a, int b){
		int count = 0;
		for(int i = a^b; i != 0; i = i >> 1){
			count += i & 1;
		}
		return count;
	}
	
	public static void main(String args[]){
		int a = 8;
		int b = 2;
		BitNumberSwap swap = new BitNumberSwap();
		System.out.println(swap.bitSwapRequiredByMe(a, b));
	}
	
}
