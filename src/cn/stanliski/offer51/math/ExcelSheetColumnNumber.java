package cn.stanliski.offer51.math;

/**
 * Excel Sheet Column Number
 * @author stanley_hwang
 *
 */
public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		 if (s == null || s.isEmpty())
	            return 0; // invalid input
	            
	        char[] chars = s.toCharArray();
	        int r = 0;
	        for (char c : chars)
	        {
	            r = r * 26 + (c - 'A') + 1;
	        }
	        return r;
	}
	
	public static void main(String args[]){
		ExcelSheetColumnNumber number = new ExcelSheetColumnNumber();
		System.out.println(number.titleToNumber("ABCA"));
	}
	
}	
