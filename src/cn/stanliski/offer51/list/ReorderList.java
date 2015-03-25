package cn.stanliski.offer51.list;

/**
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * Reorder List
 * 
 * @author stanley_hwang
 *
 */
public class ReorderList {

	public void reorderList(ListNode head) {  
		if(head == null)
			return;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode oddNode = null;
		if(slow.next != null){
			oddNode = reverse(slow.next);
		}
		slow.next = null;
		ListNode evenNode = dummy.next, lastNode = dummy;
		int i = 0;
		while(evenNode != null && oddNode != null){
			if(i % 2 == 0){
				lastNode.next = evenNode;
				lastNode = evenNode;
				evenNode = evenNode.next;
			}else{
				lastNode.next = oddNode;
				lastNode = oddNode;
				oddNode = oddNode.next;
			}
			i++;
		}
		if(oddNode != null)
			lastNode.next = oddNode;
		if(evenNode != null)
			lastNode.next = evenNode;
	}

	public ListNode reverse(ListNode head){
		ListNode pPre = null, pNode = head;
		while(pNode != null){
			ListNode pNext = pNode.next;
			pNode.next = pPre;
			pPre = pNode;
			pNode = pNext;
		}
		return pPre;
	}

	public ListNode head;

	public ListNode rear;

	public void add(int[] data){
		for(int i = 0; i < data.length; i++){
			if(head == null){
				this.head = new ListNode(data[i]);
				this.rear = head;
			}else{
				ListNode newNode = new ListNode(data[i]);
				rear.next = newNode;
				rear = newNode;
			}
		}
	}

	public void printList(ListNode head){
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	
	public static void main(String args[]){
		ReorderList list = new ReorderList();
		list.add(new int[]{1,2,0});
		list.printList(list.head);
		list.reorderList(list.head);
		System.out.println();
		list.printList(list.head);
	}


}
