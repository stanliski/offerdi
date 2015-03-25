package cn.stanliski.offer51.tree;

/**
 * 
 * Contruct binary tree from inorder annd levelorder traversal.
 * @author stanley_hwang
 *
 */
public class ConstructBinaryTreefromInorderandLevelorderTraversal {
	
	public int findPosition(int[] inorder, int is, int ie, int value){
		for(int i = is; i <= ie; i++){
			if(inorder[i] == value)
				return i;
		}
		return -1;
	}
	
	public TreeNode buildTree(int[] inorder, int[] levelorder) {
		if(inorder.length != levelorder.length)
			return null;
		return buildTreeHelper(inorder, 0, inorder.length-1, levelorder);
	}
	
	private int index = 0;
	
	public TreeNode buildTreeHelper(int[] inorder, int is, int ie, int[] levelorder){
		if(is > ie && index < levelorder.length)
			return null;
		TreeNode node = new TreeNode(levelorder[index]);
		int pos = findPosition(inorder, is, ie, levelorder[index]);
		node.left = buildTreeHelper(inorder, is, pos-1, levelorder);
		index++;
		node.right = buildTreeHelper(inorder, pos+1, ie, levelorder);
		return node;
	}
	
	public void preorder(TreeNode p){
		if(p != null){
			System.out.print(p.val + " ");
			preorder(p.left);
			preorder(p.right);
		}
	}
	
	public void inorder(TreeNode p){
		if(p != null){
			inorder(p.left);
			System.out.print(p.val + " ");
			inorder(p.right);
		}
	}
	
	public static void main(String args[]){
		int[] inorder = new int[]{4,2,5,1,6,3,7};
		int[] levelorder = new int[]{1,2,3,4,5,6,7};
		ConstructBinaryTreefromInorderandLevelorderTraversal traversal = new ConstructBinaryTreefromInorderandLevelorderTraversal();
		TreeNode root = traversal.buildTree(inorder, levelorder);
		traversal.preorder(root);
		traversal.inorder(root);
	}
	
}
