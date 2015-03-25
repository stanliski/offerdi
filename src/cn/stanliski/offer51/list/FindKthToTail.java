package cn.stanliski.offer51.list;

/**
 * Find Kth tails.
 * 
 * @author Stanley
 *
 */
public class FindKthToTail {
	
	public int length(ListNode p){
		int num = 0;
		while(p != null){
			++num;
			p = p.next;
		}
		return num;
	}
	
	public ListNode rotateRight(ListNode head, int n){
		
		if(head == null || head.next == null)
			return head;
		ListNode fastNode, slowNode;
		fastNode = slowNode = head;
		int num = length(head);
		if(n > num){
			if(n % num != 0)
				n = n % num;
			else 
				n = num;
		}
		for(int i = 0; i < n; i++)
			fastNode = fastNode.next;
		ListNode preFastNode, preSlowNode;
		preFastNode = preSlowNode = null;
		while(fastNode != null){
			preFastNode = fastNode;
			fastNode = fastNode.next;
			preSlowNode = slowNode;
			slowNode = slowNode.next;
		}
		if(preFastNode != null)
			preFastNode.next = head;
		if(preSlowNode != null)
			preSlowNode.next = null;
		head = slowNode;
		return head;
		
	}
	
	public ListNode rotateRight2(ListNode head, int n){
		
		if(head == null)
			return null;
		int length = length(head);
		n = n % length;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = dummy;
		for(int i = 0; i < n; i++){
			head = head.next;
		}
		while(head.next != null){
			tail = tail.next;
			head = head.next;
		}
		head.next = dummy.next;
		dummy.next = tail.next;
		tail.next = null;
		return dummy.next;
	
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null || n <= 0)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preDelete = dummy;
		for(int i = 0; i < n; i++){
			if(head == null)
				return null;
			head = head.next;
		}
		while(head != null){
			head = head.next;
			preDelete = preDelete.next;
		}
		preDelete.next = preDelete.next.next;
		return dummy.next;
	}
	
	public ListNode findKthToTail(){
		
		
		return null;
	}
	
	private ListNode head;
	
	private ListNode rear;
	
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
		int[] data = new int[]{1,2};
		FindKthToTail tail = new FindKthToTail();
		tail.add(data);
		tail.printList(tail.head);
		System.out.println();
		tail.printList(tail.rotateRight(tail.head, 3));
		System.out.println(1%1);
	}
	
}

