/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        while(l1 != null && l2!=null){
            if(l1.val<=l2.val){
                temp.next = l1;
                l1 = l1.next;
            }
            else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1==null ? l2: l1;
        
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0)
            return null;
        int next = 1;
        
        while(next<lists.length){
            for(int i = 0; i+next<lists.length; i = i + 2*next)
                lists[i] = mergeTwoLists(lists[i], lists[i+next]);
            next = next*2;
        }
        return lists[0];
    }
    /* Heap Solution- O(NlogK)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val- b.val;
            }
        });
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i =0; i<lists.length;i++){
            //System.out.println(lists[i]);
            if(lists[i] != null)
                pq.add(lists[i]);
        }
        
        while(pq.size()!=0){  
            ListNode now = pq.poll();
            temp.next = now;
            //System.out.println(now.val);
            if(now.next!=null)
                pq.add(now.next);
            
            temp = temp.next;
            
        }
        return dummy.next;
    }*/
}
