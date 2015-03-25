package cn.stanliski.offer51.hashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 
 * Minimum Window Substring
 * 
 * @author stanley_hwang
 *
 */
public class MinimumWindowSubstring{

	public static void main(String args[]){
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring sub = new MinimumWindowSubstring();
		String test = sub.minWindow9th(s, t);
		System.out.println(test);
	}
	
	public String minWindow9th(String S, String T) {
		
		if (S == null || S.length() == 0) {
			return S;
		}
		if (T == null || T.length() == 0) {
			return "";
		}

		HashMap <Character, Integer> tCounter = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			Character c = T.charAt(i);
			if (tCounter.containsKey(c)) {
				tCounter.put(c, tCounter.get(c) + 1);
			} else {
				tCounter.put(c, 1);
			}
		}

		HashMap<Character, Integer> minWindowCounter = new HashMap<Character, Integer>();
		String minWindow = null;
		int tCount = 0, leftBound = 0;
		for (int i = 0; i < S.length(); i++) {
			Character c = S.charAt(i);
			if (!tCounter.containsKey(c)) {
				continue;
			}

			if (minWindowCounter.containsKey(c)) {
				minWindowCounter.put(c, minWindowCounter.get(c) + 1);
			} else {
				minWindowCounter.put(c, 1);
			}
			if (minWindowCounter.get(c) <= tCounter.get(c)) {
				tCount ++;
			}

			if (tCount == T.length()) {
				while (leftBound < S.length()) {
					Character ch = S.charAt(leftBound);
					if (!tCounter.containsKey(ch)) {
						leftBound ++;
						continue;
					}

					if (minWindowCounter.get(ch) > tCounter.get(ch)) {
						minWindowCounter.put(ch, minWindowCounter.get(ch) - 1);
						leftBound ++;
						continue;
					}
					break;
				}
				// get Min window.
				if (minWindow == null || i - leftBound + 1 < minWindow.length()) {
					minWindow = S.substring(leftBound, i + 1);
				}
			}
		}
		if (minWindow == null) {
			return "";
		}
		return minWindow;

	}

	/**
	 * 
	 * Min Windows.
	 * @param S
	 * @param T
	 * @return
	 * 
	 */
	public String minWindow(String S, String T) {
		if(S == null || T == null || S.length() == 0 || T.length() == 0)
			return "";
		HashSet<Character> set = new HashSet<Character>(T.length());
		for(int i = 0; i < T.length(); i++)
			set.add(T.charAt(i));
		for(int i = 0; i < S.length(); i++){

		}
		return "";
	}

}
