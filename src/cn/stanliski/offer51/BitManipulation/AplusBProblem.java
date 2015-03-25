package cn.stanliski.offer51.BitManipulation;

public class AplusBProblem {
	
	/*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
    	if(b == 0)
    		return a;
    	System.out.println(Integer.toBinaryString(a) + ":" + Integer.toBinaryString(b));
    	int sum = a ^ b;
    	int carry = (a & b) << 1;
    	System.out.println(Integer.toBinaryString(sum) + ":" + Integer.toBinaryString(carry));
    	return aplusb(sum, carry);
    }
	
    public static void main(String args[]){
    	int a = 9;
    	int b = 8;
    	AplusBProblem p = new AplusBProblem();
    	p.aplusb(a, b);
    }
    
}
