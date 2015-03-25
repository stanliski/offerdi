package cn.stanliski.offer51.list;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * Merge k Sorted Lists
 * 
 * @author stanley_hwang
 *
 */
public class MergeKSortedLists {
	
	/**
	 * 
	 * Merge lists
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists == null || lists.size() == 0)
            return null;
        Comparator<ListNode> order = new Comparator<ListNode>(){

			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
        	
        };
        PriorityQueue heap = new PriorityQueue(lists.size(), order);
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;
        for(ListNode node : lists){
        	if(node != null){
        		heap.add(node);
        	}
        }
        while(!heap.isEmpty()){
        	ListNode node = (ListNode) heap.poll();
        	lastNode.next = node;
        	lastNode = node;
        	if(node.next != null){
        		heap.add(node.next);
        	}
        }
        return dummy.next;
        
    }
	
}
