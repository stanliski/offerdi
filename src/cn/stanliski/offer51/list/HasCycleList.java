package cn.stanliski.offer51.list;

/**
 * Has Cycle List.
 * @author Stanley
 *
 */
public class HasCycleList {
	
	public boolean hasCycleList(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
	
	public ListNode detectCycle(ListNode head){
		if(head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;
		while(fast != null || fast != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				hasCycle = true;
				break;
			}
		}
		if(!hasCycle)
			return null;
		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public ListNode detectCycle2(ListNode head){
		
		if(head == null)
			return null;
		ListNode fast, slow;
		fast = slow = head;
		do{
			if(fast == null || fast.next.next == null)
				return null;
			fast = fast.next.next;
			slow = slow.next;
		}while(slow != fast);
		
		while(head != slow){
			head = head.next;
			slow = slow.next;
		}
		return head;
	}
	
}
