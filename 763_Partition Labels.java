Input: S = "ababcbacadefegdehijhklij" //each letter appears in at most one part
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".

******************************************************************************
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i; // record the last position of the certain word
        
        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']); //assign j the value of the last position of S.charAt(i)
            if (i == j) { // the current pos is the last position of S.charAt(i)
                ans.add(i - anchor + 1); // add the length
                anchor = i + 1; // move ancor to next string
            }
        }
        return ans;
    }
}
