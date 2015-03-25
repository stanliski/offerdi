package cn.stanliski.offer51.tree;


/**
 * 
 * Construct binary tree from inorder and postorder traversal.
 * 
 * @author stanley_hwang
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversalII {

	public int findPosition(int[] inorder, int is, int ie, int value){
		for(int i = is; i <= ie; i++){
			if(inorder[i] == value)
				return i;
		}
		return -1;
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length != postorder.length)
			return null;
		return buildTreeHelper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}
	
	public TreeNode buildTreeHelper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
		if(is > ie)
			return null;
		TreeNode node = new TreeNode(postorder[pe]);
		int index = findPosition(inorder, is, ie, postorder[pe]);
		node.left = buildTreeHelper(inorder, is, index-1, postorder, ps, ps+(index-is)-1);
		node.right = buildTreeHelper(inorder, index+1, ie, postorder, ps+(index-is), pe-1);
		return node;
	}


}
