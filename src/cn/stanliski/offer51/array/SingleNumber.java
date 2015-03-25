package cn.stanliski.offer51.array;

/**
 * Single Number
 * @author stanley_hwang
 *
 */
public class SingleNumber {

	//Given an array of integers, every element appears twice except for one. Find that single one.
	public int singleNumber(int[] A) {
		if(A == null || A.length == 0)
			return -1;
		int res = 0;
		for(int i = 0; i < A.length; i++)
			res ^= A[i];
		return res;
	}
	
	public int singleNumberIII(int[] A) {  
        int[] a = new int[32];  
        int result = 0;  
        for(int i = 0; i < 32; i++) {  
            for(int j = 0; j < A.length; j++) {  
                if(((A[j] >> i) & 1) != 0)  
                    a[i] = (a[i] + 1) % 3;  
            }  
            result |= a[i] << i;  
        }  
        return result;  
    }  
	
	public int singleNumberII_ThreeAndOne(int A[], int n) {  
	    int ans = 0;  
	    for (int i = 0; i < 32; i++)   
	    {  
	        int c = 0, d = 1<<i;  
	        for (int j = 0; j < n; j++)  
	            if ((A[j] & d) == d) 
	            	c++;  
	        if (c%3 != 0) 
	        	ans |= d;  
	    }  
	    return ans;  
	}
	
	
	public int singleNumberV(int[] A){
		if(A == null || A.length == 0)
			return -1;
		int rst = 0;
		for(int i = 0; i < 32; i++){
			int c = 0;
			int d = 1 << i;
			for(int j = 0; j < A.length; j++){
				if((A[j] & d) == d){
					c++;
				}
			}
			if(c % 3 != 0)
				rst |= d;
		}
		return rst;
	}

	
	public int singleNumberII(int[] A){
		if(A == null || A.length == 0)
			return -1;
		int ones = 0, twos = 0, xthrees = 0;
		for(int i = 0; i < A.length; ++i) {
			twos |= (ones & A[i]);
			System.out.println(Integer.toBinaryString(twos));
			ones ^= A[i];
			System.out.println(Integer.toBinaryString(ones));
			xthrees = ~(ones & twos);
			System.out.println(Integer.toBinaryString(xthrees));
			ones &= xthrees;
			System.out.println(Integer.toBinaryString(ones));
			twos &= xthrees;
			System.out.println(Integer.toBinaryString(twos));
		}

		return ones;
	}

	public static void main(String args[]){
		int[] result = new int[]{1,1,1,2,3,3,1,1,1,2,2};
		SingleNumber sn = new SingleNumber();
		int rst = sn.singleNumberII_ThreeAndOne(result, result.length);
		System.out.println(rst);
		System.out.println(2 ^ 3);
	}

}
