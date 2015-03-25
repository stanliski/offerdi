package cn.stanliski.offer51.array;

import java.util.ArrayList;

/**
 * 
 * Merge Sorted Array
 * @author stanley_hwang
 *
 */
public class MergeSortedArray {

	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if(A == null || A.length == 0 || B == null || B.length == 0)
            return;
        int i = m-1, j = n-1;
        int k = m+n-1;
        while(i >= 0 && j >= 0){
            if(A[i] >= B[j]){
                A[k--] = A[i--];
            }else{
                A[k--] = B[j--];
            }
        }
        while(i >= 0){
            A[k--] = A[i--];
        }
        while(j >= 0){
            A[k--] = B[j--];
        }
    }
	
	 /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
    	if(A == null || A.size() == 0)
    		return B;
    	if(B == null || B.size() == 0)
    		return A;
    	ArrayList<Integer> C = new ArrayList<Integer>(A.size() + B.size());
    	int i = 0, j = 0;
    	while(i < A.size() && j < B.size()){
    		if(A.get(i) <= B.get(j)){
    			C.add(A.get(i));
    			i++;
    		}else{
    			C.add(B.get(j));
    			j++;
    		}
    	}
    	while(i <= A.size()-1){
    		C.add(A.get(i));
    		i++;
    	}
    	while(j <= B.size()-1){
    		C.add(B.get(j));
    		j++;
    	}
    	return C;
    }
    
    public static void main(String args[]){
    	int[] data1 = new int[]{9,10,11,12,13,0,0,0,0};
    	int[] data2 = new int[]{4,5,6,7};
    	MergeSortedArray msa = new MergeSortedArray();
    	msa.mergeSortedArray(data1, 5, data2, 4);
    }
	
}
