package cn.stanliski.offer51.array;

/**
 * 
 * Plus one.
 * 
 * @author stanley_hwang
 *
 */
public class PlusOne {

	/**
	 * Plus one.
	 * @param digits
	 * @return
	 */
	// 098762
	// 099999
	//     10
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0)
			return digits;
		int carry = 1;
		for(int i = digits.length-1; i >= 0; i--){
			int digit = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			digits[i] = digit;
			if(carry == 0)
				return digits;
		}
		int[] res = new int[digits.length + 1];
		res[0] = 1;
		return res;
	}
	
	public int[] plusOneII(int[] digits){
		if(digits == null || digits.length == 0)
			return digits;
		int carry = 1;
		for(int i = digits.length-1; i >= 0; i--){
			int newData = (digits[i] + carry);
			digits[i] = newData % 10;
			if(newData >= 10){
				carry = newData/10;
			}else{
				carry = 0;
			}
		}
		if(carry > 0){
			int[] res = new int[digits.length+1];
			res[0] = carry;
			return res;
		}
		return digits;
	}
	
	public static void main(String args[]){
		int[] data = new int[]{9};
		PlusOne one = new PlusOne();
		int[] result = one.plusOneII(data);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}

}
