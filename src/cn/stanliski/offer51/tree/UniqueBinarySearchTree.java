package cn.stanliski.offer51.tree;

import java.util.ArrayList;


/**
 * 
 * 这道题是求解所有可行的二叉查找树，从Unique Binary Search Trees中我们已经知道，可行的二叉查找树的数量是相应的卡特兰数，不是一个多项式时间的数量级，
 * 所以我们要求解所有的树，自然是不能多项式时间内完成的了。算法上还是用求解NP问题的方法来求解，也就是N-Queens中
 * 介绍的在循环中调用递归函数求解子问题。思路是每次一次选取一个结点为根，然后递归求解左右子树的所有结果，最后根据左右子树的返回的所有子树，依次选取
 * 然后接上（每个左边的子树跟所有右边的子树匹配，而每个右边的子树也要跟所有的左边子树匹配，总共有左右子树数量的乘积种情况），构造好之后作为当前树的
 * 结果返回。
 * 
 * 
 * @author stanley_hwang
 *
 */
public class UniqueBinarySearchTree {

	public  ArrayList<TreeNode> generateTrees(int n) {
		// 从1作为root开始，到n作为root结束 
		return  generateTrees(1, n);
	}

	private  ArrayList<TreeNode> generateTrees(int  left, int right){
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(left > right){
			res.add(null);
			return res;
		}
		for(int i = left; i <= right; i++){
			ArrayList<TreeNode> lefts = generateTrees(left, i-1); // 以i作为根节点，左子树由[1,i-1]构成 
			ArrayList<TreeNode> rights = generateTrees(i+1, right); // 右子树由[i+1, n]构成 
			for (int j = 0; j < lefts.size(); j++){
				for (int k = 0; k < rights.size(); k++){
					TreeNode root = new TreeNode(i);
					root.left = lefts.get(j);
					root.right = rights.get(k);
					res.add(root); // 存储所有可能行 
				}
			}
		}
		return res;
	}

}
