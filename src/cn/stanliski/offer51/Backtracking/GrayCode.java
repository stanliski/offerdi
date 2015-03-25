package cn.stanliski.offer51.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Gray Code.
 * 
 * @author stanley_hwang
 *
 */
public class GrayCode {

	public ArrayList<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (n <= 1) {
			for (int i = 0; i <= n; i++){
				result.add(i);
			}
			return result;
		}
		result = grayCode(n - 1);
		ArrayList<Integer> r1 = reverse(result);
		int x = 1 << (n-1);
		for (int i = 0; i < r1.size(); i++) {
			r1.set(i, r1.get(i) + x);
		}
		result.addAll(r1);
		return result;
	}

	public ArrayList<Integer> reverse (ArrayList<Integer> r) {
		ArrayList<Integer> rev = new ArrayList<Integer>();
		for (int i = r.size() - 1; i >= 0; i--) {
			rev.add(r.get(i));
		}
		return rev;
	}
	
	public static void main(String args[]){
		int n = 3;
		GrayCode code = new GrayCode();
		List<Integer> list = code.grayCode(n);
	}

}
