Input: [1,8,6,2,5,4,8,3,7]
Output: 49

find two numbers make (nums[j]-nums[i])*(j-i) maximum
**************************************************************
O(n) O(1)
The intuition behind this approach is that the area formed between the lines will always
be limited by the height of the shorter line. Further, the farther the lines, the more will be the area obtained.
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j){
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]){ // moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width. 
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
