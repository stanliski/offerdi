package cn.stanliski.offer51.BitManipulation;

/**
 * 
 * Print double binary.
 * 
 * @author stanley_hwang
 *
 */
public class PrintDoubleBinary {

	
	/**
	 * 
	 * Print binary.
	 * 
	 * @param num
	 * @return
	 */
	public static String printBinary(double num){
		if(num >= 1 || num <= 0){
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while(num > 0){
			if(binary.length() >= 32){
				return "ERROR";
			}
			double r = num * 2;
			if(r >= 1){
				binary.append(1);
				num = r - 1;
			}else{
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}
	
	/**
	 * Print binary 2.
	 * @param num
	 * @return
	 */
	public static String printBinary2(double num){
		if(num >= 1 || num <= 0){
			return "ERROR";
		}
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while(num > 0){
			if(binary.length() > 32){
				return "ERROR";
			}
			if(num >= frac){
				binary.append(1);
				num -= frac;
			}else{
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}
	
	public static String printBinary2Me(double num){
		if(num >= 1 || num <= 0)
			return "ERROR";
		StringBuilder binary = new StringBuilder();
		double frac = 0.5;
		binary.append(".");
		while(num > 0){
			if(binary.length() > 32){
				return "ERROR";
			}
			if(num >= frac){
				binary.append(1);
				num -= frac;
			}else{
				binary.append(0);
			}
			frac /= 2;
		}
		return binary.toString();
	}

	public static void main(String args[]){
		double num = 0.625;
		PrintDoubleBinary doubleBinary = new PrintDoubleBinary();
		String result = doubleBinary.printBinary2(num);
		System.out.println(result);
	}
	
}	
