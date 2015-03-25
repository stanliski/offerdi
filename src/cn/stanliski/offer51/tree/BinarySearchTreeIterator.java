package cn.stanliski.offer51.tree;

import java.util.Stack;

/**
 * 
 * Binary Search Tree Iterator.
 * 
 * @author stanley_hwang
 *
 */
public class BinarySearchTreeIterator {



	public class BSTIterator {

		TreeNode node = null;

		Stack<TreeNode> stack = new Stack<TreeNode>();

		public BSTIterator(TreeNode root) {
			if(root != null){
				stack.push(root);
				TreeNode node = root;
				while(node.left != null){
					node = node.left;
					stack.push(node);
				}
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			if(!stack.isEmpty())
				return true;
			return false;
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode node = stack.pop();
			int result = node.val;
			if(node.right != null){
				stack.push(node.right);
				node = node.right;
				while(node.left != null){
					stack.push(node.left);
					node = node.left;
				}
			}
			return result;
		}
	}

}
