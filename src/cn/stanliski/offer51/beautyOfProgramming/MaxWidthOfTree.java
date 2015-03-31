package cn.stanliski.offer51.beautyOfProgramming;

import java.util.LinkedList;
import java.util.Queue;


public class MaxWidthOfTree {
	
	public int getMaxWidth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int maxWidth = 1;
		while(true){
			if(queue.size() == 0)
				break;
			while(queue.size() > 0){
				TreeNode t = queue.poll();
				if(t.left != null)
					queue.add(t.left);
				if(t.right != null)
					queue.add(t.right);
			}
			maxWidth = Math.max(queue.size(), maxWidth);
		}
		return maxWidth;
	}

}
