O(n)+O(1)
************************************************************************This is perfect binary tree
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start=root;
        while(level_start!=null){
            TreeLinkNode cur=level_start;
            while(cur!=null){
                if(cur.left!=null) cur.left.next=cur.right;
                if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;
                
                cur=cur.next;
            }
            level_start=level_start.left;
        }
    }
}
****************************************************************************This is normal binary tree
public void connect(TreeLinkNode root) {
    TreeLinkNode dummyHead = new TreeLinkNode(0);
    TreeLinkNode pre = dummyHead;
    while (root != null) {
	    if (root.left != null) {
		    pre.next = root.left;
		    pre = pre.next;
	    }
	    if (root.right != null) {
		    pre.next = root.right;
		    pre = pre.next;
	    }
	    root = root.next;
	    if (root == null) {
		    pre = dummyHead;
		    root = dummyHead.next;
		    dummyHead.next = null;
	    }
    }
}
