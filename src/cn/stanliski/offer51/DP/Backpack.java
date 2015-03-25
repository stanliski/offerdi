package cn.stanliski.offer51.DP;

/**
 * NP难问题
 * Backpack
 * 这个问题涉及到了两个条件：一是物品总的大小小于或等于背包的大小，二是物品总的价值要尽量大。
 * 如果我们用子问题定义状态来描述的话可以这样解释
 * @author stanley_hwang
 * 用f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值
 *
 *
 * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}或 f[v]=max{f[v],f[v-c[i]]+w[i]}
 *
 *将前i件物品放入容量为v的背包中，现只考虑第i件物品的策略（放或不放）
 *如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中”，价值为f[i-1][v]；
 *如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的容量为v-c[i]的背包中”，
 *此时能获得的最大价值就是f[i-1][v-c[i]]再加上通过放入第i件物品获得的价值w[i]。
 *（v表示背包的最大容量，c[i]表示第i件物品的大小，w[i]表示第i件物品的价值）
 *
 *
 */
public class Backpack {

	public int backPack(int m, int[] A) {
		boolean f[][] = new boolean[A.length + 1][m + 1];
		for (int i = 0; i <= A.length; i++) {
			for (int j = 0; j <= m; j++) {
				f[i][j] = false;
			}
		}
		f[0][0] = true;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j <= m; j++) {
				f[i + 1][j] = f[i][j];
				if (j >= A[i] && f[i][j - A[i]]) {
					f[i + 1][j] = true;
				}
			} // for j
		} // for i

		for (int i = m; i >= 0; i--) {
			if (f[A.length][i]) {
				return i;
			}
		}
		return 0;
	}

}
