package cn.stanliski.offer51.list;

/**
 * Partition List
 * 
 * @author Stanley
 *
 */
public class PartitionList {

	public ListNode partition(ListNode head, int x){
		if(head == null)
			return head;
		ListNode sdummy = new ListNode(0);
		ListNode ldummy = new ListNode(0);
		ListNode llast, slast;
		slast = sdummy;
		llast = ldummy;
		while(head != null){
			ListNode pNext = head.next;
			if(head.val >= x){
				head.next = llast.next;
				llast.next = head;
				llast = head;
			}else{
				head.next = slast.next;
				slast.next = head;
				slast = head;
			}
		}
		slast.next = ldummy.next;
		return sdummy.next;
	}
	
	public ListNode partition2(ListNode head, int x){
		if(head == null)
			return head;
		ListNode leftdummy = new ListNode(0);
		ListNode rightdummy = new ListNode(0);
		ListNode left = leftdummy, right = rightdummy;
		while(head != null){
			if(head.val < x){
				left.next = head;
				left = head;
			}else{
				right.next = head;
				right = head;
			}
			head = head.next;
		}
		right.next = null;
		left.next = rightdummy.next;
		return leftdummy.next;
	}
	
}
