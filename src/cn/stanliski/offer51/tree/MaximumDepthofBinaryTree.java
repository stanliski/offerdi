package cn.stanliski.offer51.tree;

/**
 * 
 * Maximum Depth of Binary Tree
 * @author stanley_hwang
 *
 */
public class MaximumDepthofBinaryTree {
	
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getMin(root);
	}
	
	public int getMin(TreeNode root){
		if(root == null)
			return Integer.MAX_VALUE;
		if(root.left == null && root.right == null)
			return 1;
		int lh = getMin(root.left);
		int rh = getMin(root.right);
		int min = Math.min(lh, rh);
		return Math.min(lh, rh) + 1;
	}

	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		int lh = maxDepth(root.left);
		int rh = maxDepth(root.right);
		return lh >= rh ? lh + 1 : rh + 1;
	}
	
	public TreeNode buildTree(int[] array, int low, int high){
		if(array == null || array.length == 0)
			return null;
		if(low > high)
			return null;
		int mid = low + (high - low) / 2;
		TreeNode node = new TreeNode(array[mid]);
		node.left = buildTree(array, low, mid-1);
		node.right = buildTree(array, mid+1, high);
		return node;
	}
	
	public void preorder(TreeNode t){
		if(t != null){
			System.out.print(t.val + " ");
			preorder(t.left);
			preorder(t.right);
		}
	}
	
	public void inorder(TreeNode t){
		if(t != null){
			inorder(t.left);
			System.out.print(t.val + " ");
			inorder(t.right);
		}
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{1,2,3,4,5,6};
		MaximumDepthofBinaryTree tree = new MaximumDepthofBinaryTree();
		TreeNode root = tree.buildTree(arr, 0, arr.length-1);
		tree.preorder(root);
		System.out.println();
		tree.inorder(root);
		int height = tree.maxDepth(root);
		int min_height = tree.minDepth(root);
		System.out.println(height + ":" + min_height);
	}
	
}
