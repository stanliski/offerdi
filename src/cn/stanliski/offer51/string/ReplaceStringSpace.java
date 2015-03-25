package cn.stanliski.offer51.string;

/**
 * 
 * Replace String.
 * @author stanley_hwang
 *
 */
public class ReplaceStringSpace {
	
	public void replaceSpaces(char str[]){
		if(str == null || str.length == 0)
			return;
		int length = str.length;
		int spaceCount = 0;
		for(int i = 0; i < length; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		int newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for(int i = length-1; i >= 0; i--){
			if(str[i] == ' '){
				str[newLength--] = '0';
				str[newLength--] = '2';
				str[newLength--] = '%';
			}else{
				str[newLength--] = str[i];
			}
		}
	}
	
	public static void main(String args[]){
		String str = "This is a world";
		ReplaceStringSpace rss = new ReplaceStringSpace();
		rss.replaceSpaces(str.toCharArray());
		System.out.println(str);
	}
	
}
