package cn.stanliski.offer51.string;

/**
 * 
 * Compress String.
 * 
 * @author stanley_hwang
 *
 */
public class CompressString {
	
	public String compressBetter(String str){
		
		if(str == null || str.length() == 0)
			return str;
		StringBuilder sb = new StringBuilder();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			}else{
				sb.append(last);
				sb.append(count);
				last = str.charAt(i);
				count = 1;
			}
		}
		sb.append(last);
		sb.append(count);
		if(sb.length() > str.length())
			return str;
		return sb.toString();
		
	}
	
	public static void main(String args[]){
		String str = "abc";
		CompressString cs = new CompressString();
		String result = cs.compressBetter(str);
		System.out.println(result);
	}
	
}
