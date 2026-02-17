//way1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //Merge 1 st list
 //Merge 1st and 2nd list in ascending
 //Merge resultant and 3rd list in ascending
 //Merge resultant and 4th list in ascending and so on
 //TC: O(nk^2)
 //SC: O(1)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        for(ListNode list:lists){
            if(list!=null){
                merge(dummy,list);
            }
        }

        return dummy.next;


        
    }

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode curr=dummy;

        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next=head1;
                head1=head1.next;
            }else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }

        if(head1!=null){
            curr.next=head1;
        }else{
            curr.next=head2;
        }

        return dummy.next;

    }
}

//way2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //Add all the given lists in Priority Queue
 //i.e., store as min heap
 //poll the element
 //append to ans
 //move polled node to next node and add back to queue
 //TC: O(N log K)
 //SC: O(K)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode curr=dummy;
        PriorityQueue<ListNode> queue=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode list:lists){
            if(list!=null){
                queue.add(list);
            }
        }

        while(!(queue.isEmpty())){
            ListNode c=queue.poll();
            curr.next=c;
            c=c.next;
            curr=curr.next;
            if(c!=null)
            queue.add(c);

        }

        return dummy.next;


        
    }
}
