package cn.stanliski.offer51.list;

import cn.stanliski.offer51.tree.TreeNode;

/**
 * 
 * Convert Sorted List to Binary Search Tree
 * 
 * @author stanley_hwang
 *
 */
public class ConvertSortedListToBinarySearchTree {
	
	
	public TreeNode sortedListToBST(ListNode head) {  
        if(head == null)
            return null;
        return convertDFS(head, null);
    }
	
	
	public TreeNode convertDFS(ListNode low, ListNode high){
		if(low == high)
			return null;
		ListNode mid = findMid(low, high);
		TreeNode node = new TreeNode(mid.val);
		node.left = convertDFS(low, mid);
		node.right = convertDFS(mid.next, high);
		return node;
	}
	
	public ListNode findMid(ListNode head, ListNode rear){
		ListNode slow = head, fast = head;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public ListNode convert(TreeNode root){
		
		TreeNode lastNode = null;
		convertNode(root, lastNode);
		TreeNode head = lastNode;
		return new ListNode(0);
	}
	
	public void convertNode(TreeNode pNode, TreeNode lastNode){
		if(pNode == null)
			return;
		TreeNode pCurrent = pNode;
		if(pCurrent.left != null)
			convertNode(pCurrent.left, lastNode);
		pCurrent.left = lastNode;
		if(lastNode != null)
			lastNode.right = pCurrent;
		lastNode = pCurrent;
		if(pCurrent.right != null)
			convertNode(pCurrent.right, lastNode);
	}
	
	
}
