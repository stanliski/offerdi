package cn.stanliski.offer51.list;

/**
 * 
 * Reverse Linked List II
 * 
 * @author stanley_hwang
 *
 */
public class ReverseLinkedListII {
	
	public ListNode reverseBetween(ListNode head, int m , int n) {
		if(m >= n || head == null)
			return head;
		ListNode pf, ph, startNode;
		startNode = null;
		pf = ph = head;
		for(int i = 1; i < m; i++){
			if(pf != null){
				startNode = pf;
				pf = pf.next;
			}else
				break;
		}
		for(int i = 1; i < n; i++){
			if(ph != null)
				ph = ph.next;
			else 
				break;
		}
		ListNode rear = ph.next;
		ListNode newSubHead = reverse(pf, rear);
		if(startNode != null)
			startNode.next = newSubHead;
		else
			head = newSubHead;
		return head;
	}
	
	public ListNode reverse(ListNode head, ListNode rear){
		ListNode pNode, pPre, pReve;
		pPre = pReve = null;
		pNode = head;
		while(pNode != rear){
			ListNode pNext = pNode.next;
			pNode.next = pPre;
			pPre = pNode;
			pNode = pNext;
		}
		head.next = rear;
		return pPre;
	}
	
}
