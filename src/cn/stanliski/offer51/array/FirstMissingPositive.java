package cn.stanliski.offer51.array;

/**
 * 
 * First Missing Positive 
 * 
 * 算法就是把每个正整数i放到第i-1位上 
 * 比如下面的例子
 * 1 4 3 2 5
 * 第一个1，不用动
 * 1 4 3 2 5
 * 第二个4，应该放在第3位上
 * 1 2 3 4 5
 * 然后2已经在第1位上不用动了 
 * 以此类推
 * Method1 最简单的方法: 一个最简单的方法就是先排序，然后扫一遍找出第一个不连续的正数
 * 
 * @author stanley_hwang
 *
 */
public class FirstMissingPositive {

	public int firstMissingPositiveII(int[] A, int n){
		for(int i = 0; i < n; i++) {
			int temp;
			while(A[i] != i + 1 && A[i] > 0 && A[i] < n + 1 && A[i] != A[A[i] - 1]) {
				temp = A[i];
				A[i] = A[temp - 1];
				A[temp - 1] = temp;
			}
		}
		for(int i = 0; i < n; i++) {
			if(A[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

	public int firstMissingPositive(int[] A) {
		if (A == null) {
			return 1;
		}

		for (int i = 0; i < A.length; i++) {
			while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
				int tmp = A[A[i]-1];
				if (tmp == A[i]) {
					break;
				}
				A[A[i]-1] = A[i];
				A[i] = tmp;
			}
		}

		for (int i = 0; i < A.length; i ++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}

		return A.length + 1;
	}

	public static void main(String args[]){
		FirstMissingPositive positive = new FirstMissingPositive();
		int[] A = new int[]{1,4,3,3,5};
		System.out.println(positive.firstMissingPositive(A));
	}

}
