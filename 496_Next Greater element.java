Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
O(mn) + O(m)
******************************************************************************************
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        
        for (int j = 0; j < nums1.length; j++){
            int index = map.get(nums1[j]);
            while(index < nums2.length){
                if (nums2[index] > nums1[j]){
                    res[j] = nums2[index];
                    break;
                } else {
                    index++;
                }
                if(index == nums2.length) res[j] = -1;
            }
        }
        return res;
    }
}
**********************************************************************************************
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    res[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return res;
    }
}
