package cn.stanliski.offer51.string;

/**
 * 
 * Valid Number.
 * 
 * @author stanley_hwang
 *
 */
public class ValidNumber {

	public boolean isNumberII(String s){
		if(s == null || s.trim().isEmpty()){  
			return false;  
		}  
		String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
		if(s.trim().matches(regex)){  
			return  true;  
		}
		else{               
			return false;  
		}  
	}

	public boolean isNumber(String s) {
		if(s == null || s.length() == 0)
			return false;
		char[] charArray = s.trim().toCharArray();
		if(charArray.length == 0)
			return false;
		int len = charArray.length;
		int i = 0;
		boolean curPoint = false;
		boolean curE = false;
		while(i < len){
			char c = charArray[i];
			if(c == ' ' || ((int)c >= 65 && (int)c <= 90) 
					|| ((int)c >= 97 && (int)c <= 122 && c != 101)){
				return false;
			}else{
				if(c == 'e'){
					if(!curE){
						i++;
						if(i == 1 || i >= len || curPoint)
							return false;
						curE = true;
					}else{
						return false;
					}
				}else if(c == '.'){
					if(!curPoint){
						i++;
						if(charArray.length == 1 || curE)
							return false;
						if(charArray.length == 2 && (charArray[0] == '-' || charArray[0] == '+'))
							return false;
						curPoint = true;
					}else{
						return false;
					}
				}else{
					if((int)c >= 48 && (int)c <= 57){
						i++;
					}else{
						if(i == 0 && (c == '+' || c == '-'))
							i++;
						else
							return false;
					}
				}
			}
		}
		return true;
	}

	// A-Z = 65-90; a = 97 z = 122 '0' = 48 '9' = 57
	public static void main(String args[]){
		String str = " .e9";
		ValidNumber valid = new ValidNumber();
		System.out.println(valid.isNumber(str));
	}

}
