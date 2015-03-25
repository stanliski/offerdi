package cn.stanliski.offer51.array;

/**
 * 
 * Best Time to Buy and Sell Stock
 * 
 * @author stanley_hwang
 *
 */
public class BestTimetoBuyandSellStock {


	public int maxProfit9th(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;  //just remember the smallest price
		int profit = 0;
		for (int i : prices) {
			min = i < min ? i : min;
			profit = (i - min) > profit ? i - min : profit;
		}

		return profit;
	}

	/**
	 * max profit
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int	min = Integer.MAX_VALUE, max=0;
		for (int i = 0; i < prices.length; i++){
			min = Math.min(min, prices[i]);
			max = Math.max(max, prices[i]-min);
		}
		return max;
	}

	/**
	 * Max profit II.
	 * @param prices
	 * @return
	 */
	public int maxProfitII(int[] prices){
		if(prices.length == 0)
			return 0;
		int totalPrice = 0;
		int startIndex = 0;
		int i;
		for(i = 1; i < prices.length; i++){
			if(prices[i] < prices[i-1]){
				totalPrice = prices[i-1] - prices[startIndex];
				startIndex = i;
			}
		}
		if(prices[i-1] > prices[startIndex]){
			totalPrice = prices[i-1] - prices[startIndex];
		}
		return totalPrice;
	}

	/**
	 * 
	 * @param prices
	 * @return
	 * 分析：这一题约束最多只能买卖两次股票，并且手上最多也只能持有一支股票。因为不能连续买入两次股票，
	 * 所以买卖两次肯定分布在前后两个不同的区间。设p(i) = 区间[0,1,2...i]的最大利润 + 区间[i,i+1,....n-1]的
	 * 最大利润（式子中两个区间内分别只能有一次买卖，这就是第一道题的问题），那么本题的最大利润 = max{p[0],p[1],p[2],...,p[n-1]}。
	 * 根据第一题的算法2，我们可以求区间[0,1,2...i]的最大利润；同理可以从后往前扫描数组求区间[i,i+1,....n-1]的最大利润，其递归式如下：
	 * dp[i-1] = max{dp[i], maxprices - prices[i-1]}  ,maxprices是区间[i,i+1,...,n-1]内的最高价格。                
	 * 
	 * 
	 * 
	 */
	public int maxProfitIII(int[] prices){
		if (prices == null || prices.length <= 1) {
			return 0;
		}
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
		// DP from left to right;
		left[0] = 0;
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(prices[i], min);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
		//DP from right to left;
		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(prices[i], max);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
		int profit = 0;
		for (int i = 0; i < prices.length; i++){
			profit = Math.max(left[i] + right[i], profit);  
		}
		return profit;
	}

	public static void main(String args[]){
		int[] prices = new int[]{1,5,3,2,10,7};
		BestTimetoBuyandSellStock stock = new BestTimetoBuyandSellStock();
		System.out.println(stock.maxProfit9th(prices));
	}

}
