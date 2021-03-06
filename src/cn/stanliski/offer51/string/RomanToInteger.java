package cn.stanliski.offer51.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to integer
 * @author stanley_hwang
 *
 */
public class RomanToInteger {

	/**
	 * Roman to int.
	 * @param s
	 * @return
	 */
	public int romanToInt(String s) {
		if(s == null || s.length() == 0)
			return 0;
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		int result = m.get(s.charAt(s.length()-1));
		for(int i = s.length()-2; i >= 0; i--){
			if(m.get(s.charAt(i+1)) <= m.get(s.charAt(i))){
				result += m.get(s.charAt(i));
			}else{
				result -= m.get(s.charAt(i));
			}
		}
		return result;
	}

}
