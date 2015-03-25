package cn.stanliski.offer51.array;

/**
 * 
 * Palindrome Number 
 * 
 * @author stanley_hwang
 *
 */
public class PalindromeNumber {

	public boolean isPalindromeGood(int x) {
		//negative numbers are not palindrome
		if (x < 0)
			return false;

		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}

		while (x != 0) {
			int left = x / div;
			int right = x % 10;

			if (left != right)
				return false;

			x = (x % div) / 10;
			div /= 100;
		}

		return true;
	}

	public boolean isPalindrome(int x) {
		if(x == 0)
			return true;
		if(x < 0)
			return false;
		char[] array = String.valueOf(x).toCharArray();
		int i = 0;
		int j = array.length-1;
		while(i != j){
			if(array[i] != array[j])
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String args[]){
		int num = 1123211;
		PalindromeNumber pn = new PalindromeNumber();
		pn.isPalindromeGood(num);
	}

}
