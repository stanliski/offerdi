package cn.stanliski.offer51.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationAndCombination {
	
	public ArrayList<String> getPerms(String str){
		if(str == null)
			return null;
		ArrayList<String> permutations = new ArrayList();
		if(str.length() == 0){
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0);
		String remainder = str.substring(1);
		ArrayList<String> words = getPerms(remainder);
		for(String word : words){
			for(int j = 0; j <= word.length(); j++){
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}
		return permutations;
	}
	
	public String insertCharAt(String word, char c, int i){
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	public static void main(String args[]){
		String test = "ABC";
		PermutationAndCombination pac = new PermutationAndCombination();
		List<String> list = pac.getPerms(test);
		for(String word : list)
			System.out.print(word + " ");
	}

}
