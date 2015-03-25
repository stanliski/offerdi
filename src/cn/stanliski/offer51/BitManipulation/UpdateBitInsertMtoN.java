package cn.stanliski.offer51.BitManipulation;

/**
 * Update bit Insert M to N.
 * @author stanley_hwang
 *
 */
public class UpdateBitInsertMtoN {
	
	/**
	 * update bits.
	 * step1: clear bit i to j in n;
	 * step2: move bit of m to make it align to the n.
	 * step3: Merge M and N.
	 * 
	 * @param n
	 * @param m
	 * @param i
	 * @param j
	 * @return
	 */
	public int updateBits(int n, int m, int i, int j){
		int allOnes = ~0;
		System.out.println("n = " + Integer.toBinaryString(n));
		System.out.println("n = " + Integer.toBinaryString(m));
		int left = allOnes << (j + 1);
		int right = ((1 << i) - 1);
		int mask = left | right;
		int n_cleared = n & mask;
		int m_shifted = m << i;
		int result = n_cleared | m_shifted;
		System.out.println("result = " + Integer.toBinaryString(result));
		return result;
	}

	public static void main(String args[]){
		int m = 5;
		int n = 20;
		UpdateBitInsertMtoN update = new UpdateBitInsertMtoN();
		update.updateBits(n, m, 1, 3);
	}
	
}
