Input: J = "aA", S = "aAAbbbb"
Output: 3
Example 2:

Input: J = "z", S = "ZZ"
Output: 0
*******************************************************************************************
(m+n)
class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray()){
            set.add(c);
        }
        for (char c : S.toCharArray()){
            if (set.contains(c)){
                count++;
            }
        }
        return count;
    }
}
