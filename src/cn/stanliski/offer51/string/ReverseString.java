package cn.stanliski.offer51.string;

/**
 * Reverse string.
 * @author stanley_hwang
 *
 */
public class ReverseString {
	
	/**
	 * Swap char array.
	 * @param charArray
	 * @param i
	 * @param j
	 */
	public void swap(char[] charArray, int i, int j){
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}
	
	/**
	 * Reverse a string.
	 * @param str
	 */
	public void reverse(String str){
		if(str == null || str.length() == 0)
			return;
		char[] charArray = str.toCharArray();
		int i = 0;
		int j = charArray.length-1;
		while(i < j){
			swap(charArray, i, j);
			i++;
			j--;
		}
		System.out.println(new String(charArray));
	}
	
	public static void main(String args[]){
		ReverseString rs = new ReverseString();
		String str = "test";
		rs.reverse(str);
	}
	
}
