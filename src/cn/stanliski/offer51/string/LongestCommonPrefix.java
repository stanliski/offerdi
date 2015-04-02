package cn.stanliski.offer51.string;

/**
 * 
 * longest Common Prefix
 * @author stanley_hwang
 *
 */
public class LongestCommonPrefix {

	/**
	 * @param strs: A list of strings
	 * @return: The longest common prefix
	 */
	public String longestCommonPrefix(String[] strs) {
		// write your code here
		StringBuilder sb = new StringBuilder();
		if(strs == null || strs.length == 0)
			return sb.toString();
		if(strs.length == 1){
			return strs[0];
		}
		String first = strs[0];
		int j = 0;
		while(true){
			for(int i = 0; i < strs.length; i++){
				if(strs[i].equals("") || (j >= strs[i].length()) || (strs[i].charAt(j) != first.charAt(j))){
					return sb.toString();
				}
			}
			sb.append(first.charAt(j));
			j++;
		}
	}

	public static void main(String args[]){
		String[] str = new String[]{"ABC"};
		LongestCommonPrefix prefix = new LongestCommonPrefix();
		String st = prefix.longestCommonPrefix(str);
		System.out.println(st);
	}
	
}
