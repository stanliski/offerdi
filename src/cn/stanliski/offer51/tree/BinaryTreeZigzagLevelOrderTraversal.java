package cn.stanliski.offer51.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * Binary Tree Zigzag Level Order Traversal
 * 
 * @author stanley_hwang
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * Zigzag level order.
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int level = 0;
		if(root != null)
			stack.push(root);
		while(!stack.isEmpty()){
			addResults(result, stack);
			Stack<TreeNode> parents = stack;
			stack = new Stack<TreeNode>();
			while(!parents.isEmpty()){
				TreeNode node = parents.pop();
				if(level % 2 == 0){
					if(node.left != null)
						stack.push(node.left);
					if(node.right != null)
						stack.push(node.right);
				}else{
					if(node.right != null)
						stack.push(node.right);
					if(node.left != null)
						stack.push(node.left);
				}
			}
			level++;
		}
		return result;
	}
	
	

	/**
	 * @param root: The root of binary tree.
	 * @return: A list of lists of integer include 
	 *          the zigzag level order traversal of its nodes' values 
	 */
	public ArrayList<LinkedList<Integer>> zigzagLevelOrderII(TreeNode root) {
		// write your code here
		ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
		LinkedList<TreeNode> solutions = new LinkedList<TreeNode>();
		if(root != null)
			solutions.add(root);
		while(solutions.size() > 0){
		//	addResults(results, solutions);
			LinkedList<TreeNode> parents = solutions;
			solutions = new LinkedList<TreeNode>();
			for(TreeNode node : parents){
				if(node.left != null)
					solutions.add(node.left);
				if(node.right != null)
					solutions.add(node.right);
			}
		}
		return results;
	}

	public void addResults(ArrayList<ArrayList<Integer>> results, Stack<TreeNode> solution){
		ArrayList<Integer> newSolution = new ArrayList<Integer>();
		Stack<TreeNode> newslu = (Stack<TreeNode>) solution.clone();
		while(!newslu.isEmpty()){
			TreeNode node = newslu.pop();
			newSolution.add(node.val);
		}
		results.add(newSolution);
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
		int[] arr = new int[]{1,2,3,4,5,6,7};
		BinaryTreeZigzagLevelOrderTraversal tree = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = tree.buildTree(arr, 0, arr.length-1);
	//	tree.preorder(root);
	//	System.out.println();
	//	tree.inorder(root);
		ArrayList<ArrayList<Integer>> result = tree.zigzagLevelOrder(root);
	}

}
