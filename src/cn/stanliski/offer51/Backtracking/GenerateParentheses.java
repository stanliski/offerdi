package cn.stanliski.offer51.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * generate Parentheses
 * 
 * @author stanley_hwang
 *
 */
public class GenerateParentheses {

	public static void main(String args[]){
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
	}

	public ArrayList<String> generateParenthesisII(int n) {
		ArrayList<String> rst = new ArrayList<String>();
		if(n <= 0) {
			return rst;
		}
		getPair(rst, "", n, n);
		return rst;
	}

	public void getPair( ArrayList<String> rst , String s, int left, int right) {
		if(left > right || left < 0 || right < 0) {
			return; 	
		}
		if(left == 0 && right == 0) {
			rst.add(s);
			return;
		}
		getPair(rst, s + "(", left - 1, right);
		getPair(rst, s + ")", left, right - 1);
	}

	public List<String> generateParenthesis(int n) {
		if(n <= 0)	
			return null;
		ArrayList<String> list = new ArrayList<String>();
		String str = new String();
		dfs(list,str,n,n);
		return list;
	}

	private void dfs(ArrayList<String> list, String str, int left, int right){
		if(left > right)	
			return;
		//problem with ")("
		if(left == 0 && right == 0){
			list.add(str);
		}
		if(left > 0)	
			dfs(list, str + "(" , left-1, right);
		if(right > 0)	
			dfs(list, str + ")", left, right-1);
	}

}
