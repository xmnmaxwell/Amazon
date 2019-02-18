Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 O(n)  O(n)
 *******************************************************************
class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        if (root.left != null) {
            traverseHelper(root.left, true, false, ans);//if left subtree exists
        }
        if (root.right != null) {
            traverseHelper(root.right, false, true, ans);//if right subtree exists
        }
        return ans;
    }
    // onLeftBound represent if left bound exists, onRightBound represnt if right bound exists
    public void traverseHelper(TreeNode node, boolean onLeftBound, boolean onRightBound, List<Integer> ans) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {// if it is leaf, add to the list
            ans.add(node.val);
            return;
        }
        if (onLeftBound) {
            ans.add(node.val);
            if (node.left != null) {
                traverseHelper(node.left, true, false, ans);// if left subtree exists
            }
            if (node.right != null) {
                traverseHelper(node.right, node.left == null, false, ans);
            }
        } else if (onRightBound) {
            if (node.left != null) {
                traverseHelper(node.left, false, node.right == null, ans);
            }
            if (node.right != null) {
                traverseHelper(node.right, false, true, ans);
            }
            ans.add(node.val);
        } else {
            if (node.left != null) {
                traverseHelper(node.left, false, false, ans);
            }
            if (node.right != null) {
                traverseHelper(node.right, false, false, ans);
            }
        }
    }
    
}
