package cn.stanliski.offer51.array;

/**
 * 
 * Traping Rain Water.
 * 
 * @author stanley_hwang
 *
 */
public class TrapingRainWater {
	
	
	public int trapMe(int[] A){
		if(A == null || A.length == 0)
			return 0;
		int[] container = new int[A.length];
		int max = 0;
		int result = 0;
		for(int i = 0; i < A.length; i++){
			container[i] = max;
			max = Math.max(max, A[i]);
		}
		max = 0;
		for(int i = A.length-1; i >= 0; i--){
			// find the height of container.
			container[i] = Math.min(container[i], max);
			// find the elements' right max height
			max = Math.max(max, A[i]);
			// calculate the capacity of the container.
			if(container[i] > A[i]){
				result += container[i] - A[i];
			}
		}
		return result;
	}

	public int trapII(int[] A){
		if (A == null || A.length == 0)  
			return 0;  
		int[] container = new int[A.length];  
		int max = 0;  
		int result = 0;  

		for (int i = 0; i < A.length; i++) {  
			container[i] = max;  
			max = Math.max(max, A[i]);  
		}  

		max = 0;  
		for (int i = A.length - 1; i >= 0; i--) {  
			container[i] = Math.min(container[i], max);  
			max = Math.max(max, A[i]);  
			if (container[i] > A[i])  
				result += container[i] - A[i];  
		}  
		return result;  

	}

	public int trap(int[] A) {
		int sum = 0;
		int max = -1;
		int maxIndex = -1;
		int prev;

		// find the highest bar
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
				maxIndex = i;
			}
		}

		// process all bars left to the highest bar
		prev = 0;
		for (int i = 0; i < maxIndex; i++) {
			if (A[i] > prev) {
				sum += (A[i] - prev) * (maxIndex - i);
				prev = A[i];
			}
			sum -= A[i];
		}

		// process all bars right to the highest bar
		prev = 0;
		for (int i = A.length - 1; i > maxIndex; i--) {
			if (A[i] > prev) {
				sum += (A[i] - prev) * (i - maxIndex);
				prev = A[i];
			}
			sum -= A[i];
		}

		return sum;
	}

	public static void main(String args[]){
		int[] array = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		TrapingRainWater water = new TrapingRainWater();
		System.out.println(water.trapII(array));
	}

}
