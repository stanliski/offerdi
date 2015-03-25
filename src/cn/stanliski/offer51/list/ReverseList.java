package cn.stanliski.offer51.list;

/**
 * How to merge two LinkedList, 
 * 
 * how to find the middle node of the linkedList.
 * 
 * how to reverse node (between)
 * 
 * 
 * Reverse List
 * @author Stanley
 *
 */
public class ReverseList {
	
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

	public ListNode reverse(ListNode head){
		if(head == null)
			return head;
		ListNode reverseNode, pNode, pPre;
		reverseNode = pPre = null;
		pNode = head;
		while(pNode != null){
			ListNode pNext = pNode.next;
			if(pNext == null)
				reverseNode = pNode;
			pNode.next = pPre;
			pPre = pNode;
			pNode = pNext;
		}
		return reverseNode;
	}

	public ListNode reverseNode(ListNode head, ListNode endNode){
		if(head == null)
			return head;
		ListNode reverseNode, pNode, pPre;
		reverseNode = pPre = null;
		pNode = head;
		while(pNode != null){
			ListNode pNext = pNode.next;
			if(pNext == null)
				reverseNode = pNode;
			pNode.next = pPre;
			pPre = pNode;
			pNode = pNext;
		}
		return reverseNode;
	}

	/**
	 * Reverse Between List.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n){
		if(m >= n || head == null)
			return head;
		ListNode front, behi;
		ListNode startNode = head;
		ListNode endNode = head;
		front = behi = null; 
		for(int i = 1; i < m; i++){
			if(startNode != null){
				front = startNode;
				startNode = startNode.next;
			}else
				break;
		}
		for(int i = 1; i < n; i++){
			if(endNode != null)
				endNode = endNode.next;
			else
				break;
		}
		behi = endNode.next;
		ListNode newStart = reverseSubList(startNode, behi);
		if(front != null)
			front.next = newStart;
		else
			head = newStart;
		return head;
	}
	
	/**
	 * Reverse Sub List
	 * @param head
	 * @param rear
	 * @return
	 */
	public ListNode reverseSubList(ListNode head, ListNode rear){
		ListNode pPre, pNode, pRev;
		pPre = pPre = pRev = null;
		pNode = head;
		ListNode newRear = pNode;
		while(pNode != rear){
			ListNode pNext = pNode.next;
			if(pNext == rear){
				pRev = pNode;
			}
			pNode.next = pPre;
			pPre = pNode;
			pNode = pNext;
		}
		newRear.next = rear;
		return pRev;
	}
	
	/**
	 * Reverse Between 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween2(ListNode head, int m, int n){
		if(m >= n || head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		for(int i = 1; i < m; i++){
			if(head == null)
				return null;
			head = head.next;
		}
		ListNode premNode = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode, postnNode = mNode.next;
		for(int i = m; i < n; i++){
			if(postnNode == null)
				return null;
			ListNode temp = postnNode.next;
			postnNode.next = nNode;
			nNode = postnNode;
			postnNode = temp;
		}
		mNode.next = postnNode;
		premNode.next = nNode;
		return dummy.next;
	}
	
	/**
	 * Swap Pairs.
	 * Two nodes revert.
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode point = new ListNode(0);
		point.next = head;
		head = point;
		while(point.next != null && point.next.next != null){
			ListNode tmp = point.next.next;
			point.next.next.next = point.next;
			point.next = point.next.next;
			point.next.next.next = tmp;
			point = point.next.next;
		}
		return head.next;
	}
	
	/**
	 * How to merge two list.
	 * @param head1
	 * @param head2
	 */
	public void merge(ListNode head1, ListNode head2){
		int index = 0;
		ListNode dummy = new ListNode(0);
		while(head1 != null && head2 != null){
			if(index % 2 == 0){
				dummy.next = head1;
				head1 = head1.next;
			}else{
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
			index++;
		}
		if(head1 != null)
			dummy.next = head1;
		else
			dummy.next = head2;
	}
	
	/**
	 * Look, How to find middle node.
	 * @param head
	 * @return
	 */
	private ListNode findMiddle(ListNode head){
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	/**
	 * Reorder List.
	 * L0-L1-...-L(n-1)-Ln.
	 * L0-Ln-L1-L(n-1)-L2-L(n-2).
	 * @param head
	 */
	public void reorderList(ListNode head){
		if(head == null || head.next == null)
			return;
		ListNode mid = findMiddle(head);
		ListNode tail = reverse(mid.next);
		mid.next = null;
		merge(head, tail);
	}
	
	/**
	 * 
	 * Reverse Nodes in K-Group.
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k){
		if(k == 0 || k == 1)
			return head;
		ListNode cur = head;
		int length = 0;
		while(cur != null){
			cur = cur.next;
			length++;
		}
		int multi = length / k;
		if(multi == 0) 
			return head;
		ListNode preTail = null, curHead = null, curTail = null;
		ListNode preNode = null, nextNode = null;
		cur = head;
		for(int j = 0; j < multi; j++){
			preNode = null;
			for(int i = 0; i < k; i++){
				if(cur != null){
					nextNode = cur.next;
					cur.next = preNode;
					preNode = cur;
				}
				if(i == 0)
					curTail = cur;
				if(i == (k - 1))
					curHead = cur;
				cur = nextNode;
			}
			if(preTail == null)
				head = curHead;
			else 
				preTail.next = curHead;
			preTail = curTail;
		}
		curTail.next = cur;
		return head;
	}
	
	public static void main(String args[]){
		int[] data = new int[]{1,2,4,3,5,6,19};
		ReverseList reverseList = new ReverseList();
		reverseList.add(data);
	//	reverseList.printList(reverseList.head);
		reverseList.printList(reverseList.reverseKGroup(reverseList.head, 3));
	}

}
