112 whether root----> leaf path equal to k
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
O(n)  O(logn)
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
    
        if(root.left == null && root.right == null && sum - root.val == 0) return true;
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
**********************************************************************
113 find all path root----> leaf path equal to k
DFS: Save intermediate result into stack and save the stack into result array once its sum == required sum
public class Solution {
    private List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    
    public void pathSumInner(TreeNode root, int sum, Stack<Integer>path) {
        path.push(root.val);
        if(root.left == null && root.right == null)
            if(sum == root.val) resultList.add(new ArrayList<Integer>(path));
        if(root.left!=null) pathSumInner(root.left, sum-root.val, path);
        if(root.right!=null)pathSumInner(root.right, sum-root.val, path);
        path.pop();
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root==null) return resultList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }
}
