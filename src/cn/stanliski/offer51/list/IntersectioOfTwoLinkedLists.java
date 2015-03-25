package cn.stanliski.offer51.list;

/**
 * Intersection of two linked List
 * @author Stanley
 *
 */
public class IntersectioOfTwoLinkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		return null;
	}
	
	public int length(ListNode p){
		int num = 0;
		while(p != null){
			++num;
			p = p.next;
		}
		return num;
	}
	
}
