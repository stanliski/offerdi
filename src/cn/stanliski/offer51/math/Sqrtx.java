package cn.stanliski.offer51.math;

/**
 * 
 * Sqrt(x) 
 * 
 * @author stanley_hwang
 *
 */
public class Sqrtx {

	public int sqrt(int x) {
		long lo = 0;
		long hi = x;

		while (hi >= lo) {     
			long mid = lo+(hi-lo)/2;
			if (x < mid * mid) {
				hi = mid-1;      // not hi = mid
			} else {
				lo = mid+1;  
			}
		}
		return (int) hi;
	}
	
	public static void main(String args[]){
		int num = 8;
		Sqrtx sqrtx = new Sqrtx();
		System.out.println(sqrtx.sqrt(num));
	}
	
}
