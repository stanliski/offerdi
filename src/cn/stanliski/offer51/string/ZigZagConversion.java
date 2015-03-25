package cn.stanliski.offer51.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Zig zag Conversion.
 * 
 * @author stanley_hwang
 *
 */
public class ZigZagConversion {
	
	
	/**
	 * Co
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convertII(String s, int nRows){
		if(s == null || s.length() == 0 || nRows <= 1){
			return s;
		}
		String[] result = new String[nRows];
		for(int i = 0; i < result.length; i++){
			result[i] = "";
		}
		char[] array = s.toCharArray();
		int len = array.length;
		int j = 0;
		for(int i = 0; i < len; ){
			while(i < len && j < nRows){
				result[j] = result[j] + array[i];
				j++; 
				i++;
			}
			j = nRows - 2;
			while(i < len && j > 0){
				result[j] = result[j] + array[i];
				j--;
				i++;
			}
		}
		String finalResult = "";
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
			finalResult += result[i];
		}
		return finalResult;
	}
	
	/**
	 * 
	 * Convert.
	 * 
	 * @param s
	 * @param nRows
	 * @return
	 */
	public String convert(String s, int nRows) {
		if(s == null || s.length() == 0 || nRows <= 1)
			return s;
		char[] charArray = s.toCharArray();
		int i = 0;
		String result = "";
		int index = 0;
		while(i < nRows){
			index = i;
			result += charArray[index];
			index = index + (nRows - (i+1)) * 2;
			if(index < s.length() && result.length() < s.length()){
				result += charArray[index];
			}
			int further = index + ((i+1)-1) * 2;
			if(further != index && result.length() < s.length()){
				if(further < s.length())
					result += charArray[further];
			}
			i++;
		}
		return result;
	}
	
	public static void main(String args[]){
		String s = new String("123456789");
		ZigZagConversion conversion = new ZigZagConversion();
		System.out.println(conversion.convertII(s, 2));
	}

}
