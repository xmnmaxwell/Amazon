Given a Binary Search Tree and a target number, 
return true if there exist two elements in the BST such that their sum is equal to the given target.
******************************************************************************************************
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> tree = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        if (root == null) return false;
        helper(tree, root);
        
        for (int i = 0; i < tree.size(); i++){
            map.put(tree.get(i), i);
        }
        
        for (int i = 0; i < tree.size(); i++){
            if (map.containsKey(k-tree.get(i)) && map.get(k-tree.get(i)) != i)
                return true;
        }
        
        return false;
    }
    
    private void helper(ArrayList<Integer> tree, TreeNode root){
        if (root == null) return;
        
        helper(tree, root.left);
        helper(tree, root.right);
        
        tree.add(root.val);
    }
}
