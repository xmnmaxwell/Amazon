remove 倒数第N个，先用快速指针移到n-1，然后再让快慢指针一起移动
*********************************************************************
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// fast and slow pointers
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        //scan the fast pointer to (n-1)th element
        for (int i = 1; i <= n; i++){
            fast = fast.next;
        }
        //move the two pointers together and find the back N element
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // delete the required element
        slow.next = slow.next.next;
        return dummy.next;
    }
}
