package cn.stanliski.offer51.array;

/**
 * 
 * Excel Sheet Column Title.
 * 
 * @author stanley_hwang
 *
 */
public class ExcelSheetColumnTitle {

	public String convertToTitle(int n) {
		String result = new String("");
		if(n < 0)
			return result;
		int divNum = 0, modNum = 0;
		while(n != 0){
			if(n <= 26){
				result += (char)('A' + (n-1) % 26) + result;
				return result;
			}
			divNum = (n-1) / 26;
			modNum = (n-1) % 26;
			char c = (char)('A' + modNum);
			result = c + result;
			if(divNum > 26){
				n = divNum;
			}else{
				char t = (char)('A' + divNum - 2);
				result = t + result;
				n = 0;
			}
		}
		return result;
	}

	public String convertToTitleII(int n){
		String res = "";  
		while(n != 0)  
		{  
			res = (char)('A' + (n-1)%26) + res;  
			n = (n-1) / 26;  
		}  
		return res;  
	}

	public static void main(String args[]){
		int num = 72;
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		String data = esct.convertToTitleII(num);
		System.out.println(data);
	}
}
