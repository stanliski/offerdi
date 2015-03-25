package cn.stanliski.offer51.string;

import java.util.HashMap;

/**
 * Is Unique characters.
 * @author stanley_hwang
 *
 */
public class IsUniqueChars2 {

	/**
	 * To Binary.
	 * @param x
	 * @return
	 */
	public String toBinary(int x){
		String str=new String();
		while(x != 0){
			str = String.valueOf( x % 2 ).concat(str);
			x = x/2;
		}
		return str;
	}
	
	/**
	 * Bit Map.
	 * 
	 * So the storage cost is only str.length/8 B.
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUniqueChars2III(String str){
		if(str.length() > 256)
			return false;
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i) - 'a';
			if((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val); // set bits.
		}
		return true;
	}
	
	
	public boolean isUniqueChars2IIIMe(String str){
		if(str.length() > 256)
			return false;
		int checker = 0;
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if((checker & (1 << val)) > 0){
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	public boolean isUniqueChars2I(String str){
		if(str.length() > 256)
			return false;
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>(256);
		for(int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, true);
			}else{
				return false;
			}
		}
		return true;
	}


	public boolean isUniqueChars2II(String str){
		// because the table only have 256 characters, so the number
		// it's impossible more than 256.
		if(str.length() > 256)
			return false;
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String args[]){
		// move to left equals to 2^3
		System.out.println(1 << 3);

		System.out.println(1 >> 2);
		String str = new String("abcde");
		IsUniqueChars2 is = new IsUniqueChars2();
		System.out.println(is.isUniqueChars2III(str));
	}

}
