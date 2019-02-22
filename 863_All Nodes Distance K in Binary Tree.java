As we know, if the distance from a node to target node is k, the distance from its child to the target node is k + 1 
unless the child node is closer to the target node which means the target node is in it's subtree
To avoid this situation, we need to travel the tree first to find the path from root to target, to:
store the value of distance in hashamp from the all nodes in that path to target
Then we can easily use dfs to travel the whole tree. Every time when we meet a treenode which has already stored in map, 
use the stored value in hashmap instead of the value from its parent node.
***************************************************************************************************
class Solution {
    
    Map<TreeNode, Integer> map = new HashMap<>();
        
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map.get(root), res);
        return res;
    }
    
    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
		int right = find(root.right, target);
		if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }
    
    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) length = map.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
    }
}
