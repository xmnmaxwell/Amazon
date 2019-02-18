A top down approach is similar to an in-order traversal. We use a variable length to store the current consecutive path length and pass
it down the tree. As we traverse, we compare the current node with its parent node to determine if it is consecutive. If not, we reset the length.
O(n)+O(n)
private int maxLength = 0;
public int longestConsecutive(TreeNode root) {
    dfs(root, null, 0);
    return maxLength;
}

private void dfs(TreeNode p, TreeNode parent, int length) {
    if (p == null) return;
    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
    maxLength = Math.max(maxLength, length);
    dfs(p.left, p, length);
    dfs(p.right, p, length);
}
