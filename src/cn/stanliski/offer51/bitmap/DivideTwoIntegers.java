package cn.stanliski.offer51.bitmap;

/**
 * 
 * Divide Two Integers
 * 
 * @author stanley_hwang
 *
 */
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		boolean negative = (dividend > 0 && divisor < 0) ||
				(dividend < 0 && divisor > 0);
		if(dividend == -2147483648 && divisor == -1)
			return 2147483647;
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		int ans = 0;

		while (a >= b) {
			int shift = 0;
			while ((b << shift) <= a) {
				shift++;
			}
			ans += 1 << (shift-1);
			a = a - (b << (shift-1));
		}

		return negative ? -ans : ans;
	}

}
