package cn.stanliski.offer51.string;

/**
 * 
 * Check if s2 is the substring of s1.
 * 
 * @author stanley_hwang
 *
 */
public class RotateSubString {
	
	public boolean isRotation(String s1, String s2){
		int len = s1.length();
		if(len != s2.length())
			return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
	}
	
	public boolean isSubstring(String s1, String s2){
		return true;
	}
	
}
