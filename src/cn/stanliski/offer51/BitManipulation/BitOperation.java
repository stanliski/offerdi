package cn.stanliski.offer51.BitManipulation;

/**
 * 
 * Bit Operation.
 * @author stanley_hwang
 *
 */
public class BitOperation {
	
	/**
	 * Get Bit
	 * @param num
	 * @param i
	 * @return
	 */
	public boolean getBit(int num, int i){
		// not equal to 0, the result is 1
		if((num & (1 << i)) != 0)
			return true;
		// equal to 0, the result is 0
		return false;
	}
	
	/**
	 * Set bit, set one bit equals to 1
	 * @param num
	 * @param i
	 * @return
	 */
	public int setBit(int num, int i){
		return (num | (1 << i));
	}

	public int clearBit(int num, int i){
		int mask = ~(1 << i);
		return num & mask;
	}
	
	/**
	 * clear bits through i - the end.
	 * @param num
	 * @param i
	 * @return
	 */
	public int clearBitsMSthroughI(int num, int i){
		int mask = (1 << i) - 1;
		return num & mask;
	}
	
	/**
	 * clear Bits through 0 - i
	 * @param num
	 * @param i
	 * @return
	 */
	public int clearBitsItthrough0(int num, int i){
		int mask = ~((1 << (i + 1)) - 1);
		return num & mask;
	}
	
	public static String toBinary(int x){
		String str=new String();
		while(x != 0){
			str = String.valueOf( x % 2 ).concat(str);
			x = x/2;
		}
		return str;
	}

	public static void main(String args[]){
		BitOperation bitOperation = new BitOperation();
		int result = bitOperation.setBit(2, 3);
		System.out.println(result);
	}

}
