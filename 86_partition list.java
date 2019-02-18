Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
O(n) + O(1)
****************************************************************************
class Solution {
    public ListNode partition(ListNode head, int x) {
        //做两个dummy list，分别判断小于就放左边，大就放右边，最后一步记得把右的next设置为null
        if (head == null) return null;
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        while(head != null){
            if(head.val < x){
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next; 
    }
}
