package cn.stanliski.offer51.tree;

/**
 * Check BST
 * @author stanley_hwang
 *
 */
public class CheckBST {
	
	public boolean checkBST(TreeNode n){
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static int last_visited = Integer.MAX_VALUE;
	
	public boolean checkBSTII(TreeNode n){
		if(n == null)
			return false;
		if(!checkBSTII(n.left))
			return false;
		if(last_visited >= n.val)
			return false;
		last_visited = n.val;
		if(!checkBSTII(n.right))
			return false;
		return true;
	}
	
	public boolean checkBST(TreeNode n, int min, int max){
		if(n == null)
			return true;
		if(n.val < min || n.val >= max)
			return false;
		if(!checkBST(n.left, min, n.val) || !checkBST(n.right, n.val, max)){
			return false;
		}
		return true;
	}

	public void preOrder(TreeNode n){
		if(n != null){
			System.out.print(n.val + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}
	
	public void inOrder(TreeNode n){
		if(n != null){
			inOrder(n.left);
			System.out.print(n.val + " ");
			inOrder(n.right);
		}
	}
	
	public TreeNode createTree(int low, int high, int[] data){
		if(low >= high)
			return null;
		int mid = (low + (high - low) / 2);
		TreeNode n = new TreeNode(data[mid]);
		n.left = createTree(low, mid, data);
		n.right = createTree(mid+1, high, data);
		return n;
	}
	
	public static void main(String args[]){
		int[] data = new int[]{1,2,3,4,5,6};
		CheckBST check = new CheckBST();
		TreeNode root = check.createTree(0, data.length-1, data);
		check.preOrder(root);
		System.out.println();
		check.inOrder(root);
		System.out.println(check.checkBST(root));
	}
	
}
