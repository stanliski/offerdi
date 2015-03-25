package cn.stanliski.offer51.BitManipulation;

public class Swap {
	
	public void swap(int a, int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
	}
	
	public static void main(String args[]){
		int a = 2;
		int b = 3;
		Swap s = new Swap();
		s.swap(a, b);
	}
	
}
