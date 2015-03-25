package cn.stanliski.offer51.BitManipulation;

/**
 * 
 * Convert Integer A to Integer B
 * @author stanley_hwang
 *
 */
public class ConvertIntegerAtoIntegerB {
	
	/**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
    	int data = a ^ b;
    	int count = 0;
    	while(data != 0){
    		count++;
    		data &= (data-1);
    	}
    	return count;
    }
	
}
