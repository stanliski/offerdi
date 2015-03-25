package cn.stanliski.offer51.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Largest Number.
 * 
 * @author stanley_hwang
 *
 */
public class LargestNumber {

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		int[] in = { 3, 2, 54, 9, 85, 859, 99 };
		sortNum(in);
		System.out.println(ln.biggestNumber(in));
	}

	// 按自定义规则排序
	public static void sortNum(int[] a) {
		int temp = 0;
		for (int i = a.length - 1; i > 0; --i) {
			for (int j = 0; j < i; ++j) {
				if (compare(a[j+1],a[j])<0) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	// 输出
	public String biggestNumber(int[] num) {
		String output = new String();
		sortNum(num);
		for (int i = num.length-1; i >= 0; i--) {
			output += num[i] + "";
		}
		if(output.length()>1 && output.charAt(0)=='0')	return 0+"";
		return output;
	}

	// 排序规则
	public static int compare(int o1, int o2) {
		String s1 = o1 + "" + o2;
		String s2 = o2 + "" + o1;
		return (int) (Long.parseLong(s1) - Long.parseLong(s2));
	}

}
