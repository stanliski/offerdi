package cn.stanliski.offer51.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Binary Tree Level Order Traversal
 * 
 * @author stanley_hwang
 *
 */
public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param root
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return result;
		return result;
	}


	public void levelOrderIII(TreeNode root){

		if(root == null) return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode current = queue.poll();
			System.out.print(current.val + " ");
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
		}
	}

	public ArrayList<ArrayList<TreeNode>> levelOrderII(TreeNode root){

		ArrayList<ArrayList<TreeNode>> result = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		if(root != null)
			current.add(root);
		while(current.size() > 0){
			result.add(current);
			ArrayList<TreeNode> parents = current;
			current = new ArrayList<TreeNode>();
			for(TreeNode t : parents){
				if(t.left != null)
					current.add(t.left);
				if(t.right != null)
					current.add(t.right);
			}
		}
		return result;

	}


	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		createLevelLinkedList(root, result, 0);
		return result;
	}

	/**
	 * Create Level Linked List.
	 * @param root
	 * @param lists
	 * @param level
	 */
	public void createLevelLinkedList(TreeNode root, ArrayList<ArrayList<Integer>> lists, int level){
		if(root == null)
			return;
		ArrayList<Integer> list = null;
		if(lists.size() == level){
			list = new ArrayList<Integer>();
			lists.add(list);
		}else{
			list = lists.get(level);
		}
		list.add(root.val);
		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);
	}

}
