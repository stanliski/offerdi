package cn.stanliski.offer51.tree;

/**
 * 
 * Sum Root to Leaf Numbers
 * 
 * @author stanley_hwang
 *
 */
public class SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return sumNumbersHelper(root, 0);
	}

	private int sumNumbersHelper(TreeNode root, int prev){
		if(root == null) {
			return 0;
		}

		int sum = root.val + prev * 10;
		if(root.left == null && root.right == null) {
			return sum;
		}

		return sumNumbersHelper(root.left, sum) + sumNumbersHelper(root.right, sum);
	}
	
	private int sumNumbersHelperMe(TreeNode root, int prevsum){
		if(root == null)
			return 0;
		int sum = root.val + prevsum * 10;
		if(root.left == null && root.right == null)
			return sum;
		return sumNumbersHelperMe(root.left, sum) + sumNumbersHelperMe(root.right, sum);
	}

}
