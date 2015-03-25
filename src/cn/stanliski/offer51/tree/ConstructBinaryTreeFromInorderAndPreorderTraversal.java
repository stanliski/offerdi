package cn.stanliski.offer51.tree;

/**
 * 
 * Construct binary tree from inorder and postorder traversal.
 * 
 * @author stanley_hwang
 *
 */
public class ConstructBinaryTreeFromInorderAndPreorderTraversal {

	public int findPosition(int[] inorder, int instart, int inend, int data){
		for(int i = instart; i <= inend; i++){
			if(inorder[i] == data)
				return i;
		}
		return -1;
	}
	
	public TreeNode buildTreeHelper(int[] inorder, int instart, int inend, int[] preorder,
			int prestart, int preend){
		if(instart > inend)
			return null;
		TreeNode root = new TreeNode(preorder[prestart]);
		int position = findPosition(inorder, instart, inend, preorder[prestart]);
		root.left = buildTreeHelper(inorder, instart, position-1, preorder, prestart+1, prestart+(position-instart));
		root.right = buildTreeHelper(inorder, position+1, inend, preorder, prestart+(position-instart) + 1, preend);
		return root;
	}
	
	/**
	 * Build tree.
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// write your code here
		if(preorder == null || inorder == null 
				|| preorder.length == 0 || inorder.length == 0)
			return null;
		return buildTreeHelper(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
	}

}
