package cn.stanliski.offer51.list;

/**
 * 
 * Sort List.
 * 
 * @author Stanley
 *
 */
public class SortList {

	private ListNode head;

	private ListNode rear;

	//use the fast and slow pointer to get the middle of a ListNode
	ListNode getMiddleOfList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next !=null && fast != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode sortListII(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode middle = getMiddleOfList(head);
		ListNode next = middle.next;
		middle.next = null;
		return mergeList(sortListII(head), sortListII(next));
	}

	//merge the two sorted list
	ListNode mergeList(ListNode a, ListNode b) {
		
		ListNode dummyHead = new ListNode(-1);
		ListNode curr = dummyHead;
		while(a != null && b != null) {
			if(a.val <= b.val) {
				curr.next = a;
				a = a.next;
			}else{
				curr.next = b;
				b = b.next;
			}
			curr = curr.next;
		}
		curr.next = a != null? a : b;
		return dummyHead.next;
	
	}

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

	public ListNode insertionSortList(ListNode head){
		ListNode dummy = new ListNode(0);
		ListNode pNode = head;
		while(pNode != null){
			ListNode node = dummy;
			while(node.next != null && node.next.val < pNode.val){
				node = node.next;
			}
			ListNode pNext = pNode.next;
			pNode.next = node.next;
			node.next = pNode;
			pNode = pNext;
		}
		return dummy.next;
	}

	public ListNode merge(ListNode head1, ListNode head2){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(head1 != null && head2 != null){
			if(head1.val <= head2.val){
				tail.next = head1;
				head1 = head1.next;
			}else{
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		if(head1 != null)
			tail.next = head1;
		else 
			tail.next = head2;
		return dummy.next;
	}

	public ListNode findMid(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode sortList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode mid = findMid(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}

	public static void main(String args[]){
		int[] data = new int[]{1,4,2,5,3,6,19};
		SortList s = new SortList();
		s.add(data);
		s.printList(s.sortList(s.head));
	}

}
