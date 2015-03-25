package cn.stanliski.offer51.tree;

import java.util.HashMap;

/**
 * 
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Through HashMap we can quickly find the left node and right node.
 * 
 * 比如如果postorder 是84526731，inorder是84521637，首先我们可以知道postorder的最后一个数1必然是root，
 * 然后我们可以在inorder里面找到这个root 1，进而把inorder划分成了左半部分8452和右半部分637，
 * 显然 8452和 637就是左右子树的inorder序列。同时我们还可以求出左右子树中node的个数，
 * 在这个例子中左子树有4个node，右子树有3个node，然后我们可以利用这个信息去postorder里面去找到左右子树的postorder序列，
 * 分别是8452和673，于是我们就知道了左子树和右子树的inorder及postorder，划归为了规模小1的原问题，
 * 于是就可以递归实现了。实现中用到了一个hashmap来保存inorder从value到index的映射，可以在o（1）的时间内从val得到index。
 * 注意这题假设树中所有val没有重复，如果有重复要在inorder中找到哪个是root就困难了。
 * 遇到关于tree的题目往往和递归有关，可以通过画一个实例来找规律，找出f(n)和f(n-1)的关系，一般可以从 f(n-1)出发推算出 f(n)，就可以递归实现。
 * 
 * @author stanley_hwang
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	
	public TreeNode buildTreeMe(int[] inorder, int[] postorder){
		HashMap<Integer, Integer> inorderValueToIndexMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			inorderValueToIndexMap.put(inorder[i], i);
		}
		return buildTreeHelperTest(postorder, 0, postorder.length, 
					inorder, 0, inorder.length, inorderValueToIndexMap);
	}
	
	public TreeNode buildTreeHelperTest(int[] postorder, int ps, int pe, int[] inorder,
			int is, int ie, HashMap<Integer, Integer> inorderValueToIndexMap){
		if(ps > pe || is > ie){
			return null;
		}
		TreeNode root = new TreeNode(postorder[pe]);
		int indexOfRootInorder = inorderValueToIndexMap.get(root.val);
		int leftNum = indexOfRootInorder - is;
		int rightNum = ie - indexOfRootInorder;
		root.left = buildTreeHelperTest(postorder, ps, ps + leftNum - 1, inorder, 
				indexOfRootInorder - leftNum, indexOfRootInorder - 1, inorderValueToIndexMap);
		root.right = buildTreeHelperTest(postorder, ps + leftNum, ps + leftNum + rightNum -1 , inorder, indexOfRootInorder + 1,
				indexOfRootInorder + rightNum, inorderValueToIndexMap);	
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		
		HashMap<Integer, Integer> inorderValueToIndexMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < inorder.length; i++){
			inorderValueToIndexMap.put(inorder[i], i);
		}
		return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inorderValueToIndexMap);

	}

	public TreeNode buildTreeHelper(int [] postorder, int ps, int pe, int[] inorder, 
				int is, int ie, HashMap<Integer, Integer> inorderValueToIndexMap){
		if(ps > pe || is > ie) 
			return null;
		TreeNode root = new TreeNode(postorder[pe]);
		
		int indexOfRootInorder = inorderValueToIndexMap.get(root.val);
		
		int leftNum = indexOfRootInorder - is;
		int rightNum = ie - indexOfRootInorder;
		
		root.left = buildTreeHelper(postorder, ps, ps + leftNum - 1, inorder, 
					indexOfRootInorder - leftNum, indexOfRootInorder -1, inorderValueToIndexMap);
		
		root.right = buildTreeHelper(postorder, ps + leftNum, ps + leftNum + rightNum - 1, inorder, 
					indexOfRootInorder + 1, indexOfRootInorder + rightNum, inorderValueToIndexMap);
		
		return root;
	}

}
