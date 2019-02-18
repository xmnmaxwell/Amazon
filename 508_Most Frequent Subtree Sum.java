Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
*******************************************************************************************
public class Solution {
    int maxFreq = 0;
    int count = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        traverse(root, map);
        int[] res = new int[count];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
    
    private int traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        int left = traverse(root.left, map);
        int right = traverse(root.right, map);
        
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        if (map.get(sum) > maxFreq) {
            maxFreq = map.get(sum);
            count = 1;
        } else if (map.get(sum) == maxFreq) {
            count++;
        }
        return sum;
    }
}
