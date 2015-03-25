package cn.stanliski.offer51.hashTable;

/**
 * 
 * Fraction to Recurring Decimal 
 * 
 * @author stanley_hwang
 *
 */
public class FractiontoRecurringDecimal {

	public String fractionToDecimalII(int numerator, int denominator){
		if(numerator == 0)
			return "" + 0;
		String result = new String();
		int remainder = 0;
		if(numerator >= denominator){
			result += numerator / denominator;
			remainder = (numerator % denominator);
		}else{
			result = "" + 0;
			remainder = (numerator*10) / denominator;
		}
		if(remainder == 0){
			return result;
		}else{
			result = result + ".";
			result = dfs(result, remainder*10, denominator, -1);
		}
		return result;
	}
	
	public String dfs(String result, int numerator, int denominator, int origin){
		int newDigit = numerator / denominator;
		int remainder = numerator % denominator;
		if(remainder == 0){
			return result + newDigit;
		}
		if(newDigit == origin){
			return result.substring(0, result.length()-1) + "(" + origin + ")";
		}else{
			result += newDigit;
			int originData = remainder * 10 % denominator;
			result = dfs(result, remainder*10, denominator, newDigit);
		}
		return result;
	}
	
	public String fractionToDecimal(int numerator, int denominator) {
		if(numerator == 0)
			return "" + 0;
		int positive = numerator / denominator;
		int remainder = 0;
		if(positive == 0){
			remainder = numerator;
		}else
			remainder = (numerator % denominator);
		if(remainder == 0){
			return "" + positive;
		}
		int decimal = (remainder * 10 / denominator);
		remainder = (remainder * 10 % denominator);
		if(remainder == 0){
			return positive + "." + decimal;
		}else{
			return positive + ".(" + decimal + ")";
		}
	}

	public static void main(String args[]){
		FractiontoRecurringDecimal decimal = new FractiontoRecurringDecimal();
		String result = decimal.fractionToDecimalII(3, 5);
		System.out.println(result);
	}

}
