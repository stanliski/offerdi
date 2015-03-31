package cn.stanliski.offer51.DP;

import java.util.ArrayList;

public class ProductofArrayExcludeItself {

	/**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {

    	ArrayList<Long> rst = new ArrayList<Long>(A.size());
    	if(A == null || A.size() <= 1)
    		return rst;
    	Integer[] a = new Integer[A.size()];
    	for(int i = 0; i < a.length; i++)
    		a[i] = A.get(i);
    	Long[] start = new Long[a.length];
    	Long[] end = new Long[a.length];
    	for(int i = 0; i < a.length; i++){
    		start[i] = Long.valueOf(a[i]);
    		end[i] = Long.valueOf(a[i]);
    	}
    	for(int i = 1; i < start.length; i++)
    		start[i] *= start[i-1];
    	for(int i = end.length-1; i >= 1; i--)
    		end[i-1] *= end[i];
    	for(int i = 0; i < a.length; i++){
    		if(i > 0 && i < a.length-1){
    			rst.add(Long.valueOf(start[i-1] * end[i+1]));
    		}else if(i == 0)
    			rst.add(Long.valueOf(end[i+1]));
    		else if(i == a.length-1)
    			rst.add(Long.valueOf(start[i-1]));
    	}
    	return rst;
    
    }
    
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public int[] productExcludeItselfArray(int[] a) {
    	
    	if(a == null || a.length == 0)
    		return null;
    	
    	int[] start = new int[a.length];
    	int[] end = new int[a.length];
    	start = a.clone();
    	end = a.clone();
    	for(int i = 1; i < start.length; i++){
    		start[i] *= start[i-1];
    	}
    	// {1,2,6}
    	for(int i = a.length-1; i >= 1; i--){
    		end[i-1] *= end[i];
    	}
    	// {1,6,3}
        //{6,3,2}
    	int[] result = new int[a.length];
    	
    	for(int i = 0; i < a.length; i++){
    		if(i > 0 && i < a.length-1){
    			result[i] = start[i-1] * end[i+1];
    		}else if(i == 0){
    			result[i] = end[i+1];
    		}else if(i == a.length-1){
    			result[i] = start[i-1];
    		}
    	}
		return result;
    }
    
    public static void main(String args[]){
    	int[] a = new int[]{1, 2, 3};
    	ProductofArrayExcludeItself poe = new ProductofArrayExcludeItself();
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	ArrayList<Long> rst = poe.productExcludeItself(list);
    	for(int i = 0; i < rst.size(); i++)
    		System.out.print(rst.get(i) + " ");
    }
    
	
}
