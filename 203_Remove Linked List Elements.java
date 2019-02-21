Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*******************************************
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(1);
        root.next = head;     // next of root is head; ListNode root -> ListNode head 
        ListNode pre = root; //pre is a pointer, which point to head of new root
        while (pre.next != null){
            if (pre.next.val == val)
                pre.next = pre.next.next;
            else {
                pre = pre.next;
            }
        }
        return root.next; // alway return the linked list root, not pre. pre is only pointer
    }
}
*********************************************
83. remove duplicate
Input: 1->1->2->3->3
Output: 1->2->3
********************************************************
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
      ListNode cur = head;
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next; 
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
