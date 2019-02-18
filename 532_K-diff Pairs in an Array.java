Given an array, find the number of pairs of two number, which difference is also k.
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
O(n) + O(n)
**********************************************************************************
class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums.length == 0 || nums == null || k < 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            // map.get(nums[i] + k) != i避免nums[i] + k也在nums.length之内的情况,
            if(map.containsKey(nums[i]+k) && map.get(nums[i]+k) != i){
                map.remove(nums[i]+k);
                res++;
                }
        }
        return res;
    }
}
