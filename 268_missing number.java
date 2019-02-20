Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
O(n)+O(1)

Index	0	1	2	3
Value	0	1	3	4
4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
=(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
=0∧0∧0∧0∧2
=2
*******************************************************************
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}
