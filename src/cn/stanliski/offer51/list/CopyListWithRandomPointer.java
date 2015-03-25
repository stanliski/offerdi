package cn.stanliski.offer51.list;

/**
 * 
 * Copy List with Random Pointer
 * 
 * @author stanley_hwang
 *
 */
public class CopyListWithRandomPointer {
	
	/**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
    	if(head == null)
    		return null;
    	RandomListNode pnode = head;
    	while(pnode != null){
    		RandomListNode copynode = new RandomListNode(pnode.label);
    		copynode.next = pnode.next;
    		pnode.next = copynode;
    		pnode = copynode.next;
    	}
    	pnode = head;
    	while(pnode != null){
    		if(pnode.random != null){
    			pnode.next.random = pnode.random.next;
    		}
    		pnode = pnode.next.next;
    	}
    	RandomListNode dummy1 = new RandomListNode(0);
    	RandomListNode dummy2 = new RandomListNode(0);
    	RandomListNode last1 = dummy1, last2 = dummy2;
    	pnode = head;
    	int i = 0;
    	while(pnode != null){
    		if(i % 2 == 0){
    			last1.next = pnode;
    			last1 = last1.next;
    		}else{
    			last2.next = pnode;
    			last2 = last2.next;
    		}
    		pnode = pnode.next;
    		i++;
    	}
    	head = dummy1.next;
    	return dummy2.next;
    }
    
    
	
}
