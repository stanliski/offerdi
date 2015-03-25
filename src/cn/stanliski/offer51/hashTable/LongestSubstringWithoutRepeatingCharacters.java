package cn.stanliski.offer51.hashTable;

import java.util.HashSet;

/**
 * 
 * Longest Substring without repeating characters.
 * 
 * can have some relationship with substring with concatenation of All word.
 * 
 * @author stanley_hwang
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	public static void main(String args[]){
		String str = "abbdef";
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		int num = test.lengthOfLongestSubstringMe(str);
		System.out.println(num);
	}

	public int lengthOfLongestSubstring9th(String s){
		if(s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
		int leftBound = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++){
			if(set.contains(s.charAt(i))){
				while(leftBound < i && s.charAt(leftBound) != s.charAt(i)){
					set.remove(s.charAt(leftBound));
					leftBound++;
				}
				leftBound++;
			}else{
				set.add(s.charAt(i));
				max = Math.max(max, i-leftBound+1);
			}
		}
		return max;
	}
	
	public int lengthOfLongestSubstringMe(String s){
		if(s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
		int leftBound = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++){
			if(set.contains(s.charAt(i))){
				while(leftBound < i && s.charAt(leftBound) != s.charAt(i)){
					set.remove(s.charAt(leftBound));
					leftBound++;
				}
				leftBound++;
			}else{
				set.add(s.charAt(i));
				max = Math.max(max, i-leftBound+1);
			}
		}
		return max;
	}
	
	
	public int lengthOfLongestSubstring(String s){
		if(s == null || s.length() == 0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
		int max = 0;
		int walker = 0;
		int runner = 0;
		while(runner < s.length()){
			if(set.contains(s.charAt(runner))){
				if(max < runner - walker){
					max = runner - walker;
				}
				while(s.charAt(walker) != s.charAt(runner)){
					set.remove(s.charAt(walker));
					walker++;
				}
				walker++;
			}else{
				set.add(s.charAt(runner));
			}
			runner++;
		}
		max = Math.max(max, runner-walker);
		return max;
	}
	
}
