package cn.stanliski.offer51.list;

/**
 * Merge two sorted lists.
 * @author Stanley
 *
 */
public class MergeTwoSortedLists {
	
	/**
	 * Merge two List by recursively.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode mergedNode = null;
		if(l1.val <= l2.val){
			mergedNode = l1;
			mergedNode.next = mergeTwoLists1(l1.next, l2);
		}else{
			mergedNode = l2;
			mergedNode.next = mergeTwoLists1(l1, l2.next);
		}
		return mergedNode;
	}
	
	/**
	 * Merge two List by common.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoList2(ListNode l1, ListNode l2){
		ListNode mergedNode = new ListNode(0);
		ListNode lastNode = mergedNode;
		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				lastNode.next = l1;
				l1 = l1.next;
			}else{
				lastNode.next = l2;
				l2 = l2.next;
			}
			lastNode = lastNode.next;
		}
		if(l1 != null)
			lastNode.next = l1;
		else
			lastNode.next = l2;
		return mergedNode.next;
	}
	
}
