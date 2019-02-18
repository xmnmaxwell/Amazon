Given 1->2->3->4, you should return the list as 2->1->4->3.
***************************************************************************
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null && prev.next.next != null){
            ListNode temp1 = prev.next; //store 1 address
            ListNode temp2 = prev.next.next; // store 2 address
            temp1.next = temp2.next;// 1 point to 3
            prev.next = temp2; // prev.next point to temp2 address
            prev.next.next = temp1;// prev.next.next point to temp1 address
            prev = prev.next.next;// prev move to next position for iteration
        }
        return dummy.next;
    }
}
