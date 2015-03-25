package cn.stanliski.offer51.string;

import java.util.Arrays;

/**
 * 
 * Sort string manipulation.
 * @author stanley_hwang
 *
 */
public class SortString {
	
	public boolean permutationBetter(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		int[] check = new int[256];
		for(int i = 0; i < s1.length(); i++){
			int index = s1.charAt(i);
			check[index]++;
		}
		for(int i = 0; i < s2.length(); i++){
			int index = s2.charAt(i);
			if(check[index] <= 0)
				return false;
			check[index]--;
		}
		return true;
	}
	
	public String sortEasy(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public boolean permutation(String s, String t){
		if(s.length() != t.length())
			return false;
		return sortEasy(s).equals(sortEasy(t));	
	}
	
	public static void main(String args[]){
		String word1 = "word";
		String word2 = "driw";
		SortString ss = new SortString();
		System.out.println(ss.permutationBetter(word1, word2));
	}
	
}
