Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
    
//O(n2) O(n2)    
*******************************************************************************************
class Solution {
    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        helper(root);
        return res;
    }
    public String helper(TreeNode node){
        if (node == null)  return null;
        String serial = node.val + "," + helper(node.left) + "," + helper(node.right);
        map.put(serial, map.getOrDefault(serial, 0) +1);
        if (map.get(serial) == 2)
            res.add(node);
        return serial;
    }
}
