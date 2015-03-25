package cn.stanliski.offer51.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


/**
 * 
 * Substring with concatenation of All words
 * 
 * @author stanley_hwang
 *
 */
public class SubstringWithConcatenationOfAllWords {

	public static void main(String args[]){
		String s = "barfoothefoobarfooman";
		String[] l = new String[]{"foo", "bar"};
		SubstringWithConcatenationOfAllWords allWords = new SubstringWithConcatenationOfAllWords();
		List<Integer> result = allWords.findSubstring9th(s, l);
		for(Integer index : result){
			System.out.println("index = " + index);
		}
	}

	public ArrayList<Integer> findSubstring9th(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<String, Integer> toFind = new HashMap<String, Integer>();
		HashMap<String, Integer> found = new HashMap<String, Integer>();
		int m = L.length;
		int n = L[0].length();
		for (int i = 0; i < m; i ++){
			if (!toFind.containsKey(L[i])){
				toFind.put(L[i], 1);
			}
			else{
				toFind.put(L[i], toFind.get(L[i]) + 1);
			}
		}
		for (int i = 0; i <= S.length() - n * m; i ++){
			found.clear();
			int j;
			for (j = 0; j < m; j ++){
				int k = i + j * n;
				String stub = S.substring(k, k + n);
				if (!toFind.containsKey(stub))
					break;
				if(!found.containsKey(stub)){
					found.put(stub, 1);
				}
				else{
					found.put(stub, found.get(stub) + 1);
				}
				if (found.get(stub) > toFind.get(stub))
					break;
			}
			if (j == m) 
				result.add(i);
		}
		return result;
	}

	public ArrayList<Integer> findSubstringMore(String S, String[] L) {
		ArrayList<Integer> results = new ArrayList<Integer>();
		if (S == null || S.length() == 0 || L == null || L.length == 0) {
			return results;
		}
		int N = S.length();
		int M = L.length;
		int T = L[0].length();

		HashMap<String, Integer> needToFind = new HashMap<String, Integer>();
		HashMap<String, Integer> hasFound = new HashMap<String, Integer>();
		for (int i = 0; i < M; ++i) {
			int count = 1;
			if (needToFind.containsKey(L[i])) {
				count += needToFind.get(L[i]);
			}
			needToFind.put(L[i], count);
		}

		for (int j = 0; j < T; ++j) {
			int hits = 0;
			int start = j;
			for (int i = j; i + T <= N; i += T) {
				String word = S.substring(i, i + T);
				if (!needToFind.containsKey(word)) {
					hasFound.clear();
					hits = 0;
					start = i + T;
					continue;
				}
				int count = 1;
				if (hasFound.containsKey(word)) {
					count += hasFound.get(word);
				}
				if (count <= needToFind.get(word)) {
					++hits;
					hasFound.put(word, count);
				} else {
					String startWord = S.substring(start, start + T);
					while (!startWord.equals(word)) {
						int value = hasFound.get(startWord) - 1;
						hasFound.put(startWord, value);
						--hits;
						start += T;
						startWord = S.substring(start, start + T);
					}
					start += T;
				}
				if (hits == M) {
					results.add(start);
					String startWord = S.substring(start, start + T);
					int value = hasFound.get(startWord) - 1;
					hasFound.put(startWord, value);
					--hits;
					start += T;
				}
			}
			hasFound.clear();
		}
		return results;
	}

	/**
	 * Find Substring.
	 * @param S
	 * @param L
	 * @return
	 */
	public List<Integer> findSubstring(String S, String[] L){

		if(L == null || S == null || L.length == 0){
			return new ArrayList<Integer>(0);
		}
		HashMap<String, Integer> savedSet = new HashMap<String, Integer>();
		HashSet<String> words = new HashSet<String>();
		for(int i = 0; i < L.length; i++){
			words.add(L[i]);
		}
		int len = L[0].length();
		int i = L[0].length()-1;
		int j = 0;
		int leftBound = 0;
		int max = 0;
		while(i < S.length()){
			String word = S.substring(j, i);
			if(words.contains(word)){
				if(!savedSet.containsKey(word)){
					savedSet.put(word, j);
					i = i + len;
					if(i < S.length()){
						j = i;
					}else{

					}
				}
			}
		}
		return new ArrayList<Integer>();

	}

}
