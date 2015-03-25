package cn.stanliski.offer51.list;

/**
 * Add Two Numbers.
 * @author Stanley
 *
 */
public class AddTwoNumbers {
	
	/**
	 * Add two numbers.
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode lastNode = dummy;
		while(l1 != null && l2 != null){
			int num = l1.val + l2.val + carry;
			if(num >= 10){
				carry = num / 10;
			}else{
				carry = 0;
			}
			lastNode.next = new ListNode(num % 10);
			lastNode = lastNode.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1 != null){
			while(l1 != null){
				int num = l1.val + carry;
				if(num >= 10){
					carry = num / 10;
				}else{
					carry = 0;
				}
			}
		}else{
			while(l2 != null){
				
			}
		}
		return dummy.next;
	}
	
	
	
}
