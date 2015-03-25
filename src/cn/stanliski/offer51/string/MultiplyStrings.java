package cn.stanliski.offer51.string;

/**
 * Multiple String.
 * 
 * @author stanley_hwang
 *
 */
public class MultiplyStrings {
	
	
	public String multiplyMe(String num1, String num2){
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0)
			return new String();
		int len1 = num1.length();
		int len2 = num2.length();
		int len3 = len1 + len2;
		int i, j, product, carry;
		int[] num3 = new int[len3];
		for(i = len1-1; i >= 0; i--){
			carry = 0;
			for(j = len2-1; j >= 0; j--){
				product = carry + num3[i+j+1] + (num1.charAt(i)-48) * (num2.charAt(j)-48);
				num3[i+j+1] = product % 10;
				carry = product / 10;
			}
			num3[i+j+1] = carry;
		}
		StringBuilder sb = new StringBuilder();
		i = 0;
		while(i < len3-1 && num3[i] == 0){
			i++;
		}
		while(i < len3){
			sb.append(num3[i++]);
		}
		return sb.toString();
	}

	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null) {
			return new String();
		}
		int len1 = num1.length(), len2 = num2.length();
		int len3 = len1 + len2;
		int i, j, product, carry;
		int[] num3 = new int[len3];
		for (i = len1 - 1; i >= 0; i--) {
			carry = 0;
			for (j = len2 - 1; j >= 0; j--) {
				product = carry + num3[i + j + 1] +
						Character.getNumericValue(num1.charAt(i)) *
						Character.getNumericValue(num2.charAt(j));
				num3[i + j + 1] = product % 10;
				carry = product / 10;
			}
			num3[i + j + 1] = carry;
		}
		StringBuilder sb = new StringBuilder();
		i = 0;
		while (i < len3 - 1 && num3[i] == 0) {
			i++;
		}
		while (i < len3) {
			sb.append(num3[i++]);
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		System.out.println('2'-48);
		String number1 = "121";
		String number2 = "121";
		MultiplyStrings multiple = new MultiplyStrings();
		String result = multiple.multiplyMe(number1, number2);
		System.out.println(result);
	}
	
}
