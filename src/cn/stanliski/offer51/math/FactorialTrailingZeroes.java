package cn.stanliski.offer51.math;

/**
 * 
 * Factorial Trailing Zeroes
 * 
 * @author stanley_hwang
 *
 */
public class FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		int ret = 0;
        for(int i = 1; i <= n; i ++)
        {
            int tmp = i;
            while(tmp%5 == 0)
            {
                ret ++;
                tmp /= 5;
            }
        }
        return ret;
	}
	
	public int trailingZeroesII(int n){
		int ret = 0;
		for(int i = n; i >= 1; i--){
			int tmp = i;
			while(tmp%5 == 0){
				ret++;
				tmp /= 5;
			}
		}
		return ret;
	}
	
	
	
	
	public static void main(String args[]){
		int n = 5;
		FactorialTrailingZeroes zero = new FactorialTrailingZeroes();
		System.out.println(zero.trailingZeroesII(n));
	}

}
