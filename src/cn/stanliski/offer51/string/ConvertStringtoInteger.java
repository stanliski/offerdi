package cn.stanliski.offer51.string;

/**
 * 
 * Convert String to Integer
 * 
 * @author stanley_hwang
 *
 */
public class ConvertStringtoInteger {
	
//	
//    public int atoi(String str) {
//        if(null == str || str.length() == 0)
// 			return 0;
// 		char[] arr = str.toCharArray();
// 	
// 		long res = 0;
// 		boolean isNegative = false;
// 		boolean isCurrDigit = false;
// 		for(int i = 0; i < arr.length; i++){
// 			if(isDigit(arr[i])){
// 				isCurrDigit = true;
// 				res = res * 10 + (arr[i] - 48);
// 				if(res > 2147483647L || res > 2147483648L){
// 					if(isNegative)
// 						return Integer.MIN_VALUE;
// 					else 
// 						return Integer.MAX_VALUE;
// 				}
// 			}else if(arr[i] == '-'){
// 				if(!isCurrDigit)
// 					isNegative = true;
// 				else 
// 					return 0;
// 			}else if(arr[i] == '+'){
// 				if(isCurrDigit)
// 					break;
// 			}else if(arr[i] == ' ')
// 				if(isCurrDigit)
// 					
// 			else 
// 				break;
// 		}
// 		if(isNegative){
// 			return (int) (0L-res);
// 		}else
// 			return (int) res;
//     }
//     
//     private boolean isDigit(char c){
//         return c >= 48 && c <= 57;
//     }
     
//	
//	public int atoiII(String str){
//		if(null == str || str.length() == 0)
//			return 0;
//		char[] arr = str.toCharArray();
//	
//		long res = 0;
//		boolean isNegative = false;
//		for(int i = 0; i < arr.length; i++){
//			if(isDigit(arr[i])){
//				res = res * 10 + (arr[i] - 48);
//				if(res > 2147483647L || res > 2147483648L){
//					if(isNegative)
//						return Integer.MIN_VALUE;
//					else 
//						return Integer.MAX_VALUE;
//				}
//			}else if(arr[i] == '-'){
//				isNegative = true;
//			}else if(arr[i] == '+'){
//				;
//			}else
//				break;
//		}
//		if(isNegative){
//			return (int) (0L-res);
//		}else
//			return (int) res;
//	}
//
	public int atoi(String str) {
		
		if(null == str || str.length() == 0)
			return 0;
		char[] arr = str.toCharArray();
		long res = 0; //保存结果
		
		boolean isNegative = false; //标识是否为负数
		
		boolean existed = false; //标识符号和空格是否合法
				//（只有在开头出现的符号和空格才是合法的）
		
		for(int i = 0; i < arr.length; i++){
			if(isDigit(arr[i])){
				res = res * 10 + (arr[i] - 48);
				if(!isNegative && res > Integer.MAX_VALUE)
					return Integer.MAX_VALUE;
				if(!existed) 
					existed = true;
			}else if(arr[i] == '-' && !existed){
				isNegative = true;
				if(!existed) 
					existed = true;
			}else if(arr[i] == '+' && !existed){
				if(!existed) 
					existed = true;
			}
			else if(arr[i]==' ' && !existed)//空格
				;
			else 
				break;	 //非法字符       	
		}
		if(isNegative){
			res = 0l-res;
			return res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int)res; //考虑int的范围
		}
		else {
			return res > Integer.MAX_VALUE? Integer.MAX_VALUE : (int)res;
		}
		
	}
	
	private boolean isDigit(char c){
		return c >= 48 && c <= 57;//根据Asic码
	}
	
	public static void main(String args[]){
		String data = " 15+4";
		ConvertStringtoInteger csi = new ConvertStringtoInteger();
		int number = csi.atoi(data);
		System.out.println(number);
	}
	
}
