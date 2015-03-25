package cn.stanliski.offer51.Greedy;

/**
 * 
 * Gas Station
 * 
 * @author stanley_hwang
 *
 */
public class GasStation {

	public void testCircle(int[] data){
		int i = 1;
		int j = i;
		int len = data.length;
		while((j+1)%len != i){

			System.out.println((j+1)%len + " " + data[j]);
			j++;
		}
	}

	public static void main(String args[]){
		int[] gas = new int[]{1,2};
		int[] cost = new int[]{2,1};
		GasStation gasStation = new GasStation();
		System.out.println(gasStation.canCompleteCircuit(gas, cost));
	}
	
	/**
	 * 可以转化为求最大连续子序列的题目 
	 * 	最大连续子序列：所有连续子序列中元素和最大的一个
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuitII(int[] gas, int[] cost) {
		if(gas == null || cost == null || gas.length == 0 || cost.length == 0){
			return -1;
		}
		int diff = 0;
		int total = 0;
		int max = 0;
		int index = 0;
		for(int i = 0; i < gas.length; i++){
			diff += gas[i] - cost[i];
			total += diff + (gas[i] - cost[i]);
			if(diff < 0){
				index = i;
				diff = 0;
				total = 0;
			}
			else{
				if(total > max)
					max = total;
			}
		}
		return max < 0 ? -1 : (index + 1);
	}

	/**
	 * Can complete circuit.
	 * 	Can work right, but time limit.
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
			return -1;
		}
		int len = gas.length;
		for(int i = 0; i < gas.length; i++){
			if(gas[i] >= cost[i]){
				int j = i + 1;
				int left = gas[i] - cost[i];
				while(j % len != i){
					j = j % len;
					if(left + gas[j] >= cost[j]){
						left = left + (gas[j] - cost[j]);
						j++;
						if(j % len == i)
							return i;
					}else
						break;
				}
			}
		}
		return -1;
	}

}
