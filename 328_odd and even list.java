Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
****************************************************************
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenH = even;
        while (even != null && even.next != null){
            odd.next = odd.next.next;//有顺序的不然地址会丢失。
            even.next = even.next.next;
            even = even.next;
            odd = odd.next;
        }
        odd.next = evenH;
        return head;
    }
}
