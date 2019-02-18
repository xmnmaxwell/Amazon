public class Solution {
    public boolean hasCycle(ListNode head) {
        
        ListNode pfast = head;
        ListNode pslow = head;
        while (pfast != null && pfast.next != null){
        pfast = pfast.next.next;
        pslow = pslow.next;
        
        if (pfast == pslow){
            return true;
        } 
    }
        return false;
    }
}
