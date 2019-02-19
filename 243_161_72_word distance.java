243. Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Input: word1 = “coding”, word2 = “practice”
Output: 3
O(n) + O(1)
*************************************************************************
public int shortestDistance(String[] words, String word1, String word2) {
    int i1 = -1, i2 = -1;
    int minDistance = words.length;
    int currentDistance;
    for (int i = 0; i < words.length; i++) {
        if (words[i].equals(word1)) {
            i1 = i;
        } else if (words[i].equals(word2)) {
            i2 = i;
        }

        if (i1 != -1 && i2 != -1) {
            minDistance = Math.min(minDistance, Math.abs(i1 - i2));
        }
    }
    return minDistance;
}
***************************************************************************
161. Given two strings s and t, determine if they are both one edit distance apart.
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++){
            if (s.charAt(i) != t.charAt(i)){
                if (s.length() == t.length())//如果长度相同只能replace
                    return s.substring(i+1).equals(t.substring(i+1));
                else if (s.length() < t.length())
                    return s.substring(i).equals(t.substring(i+1));//t长度更长证明只能删t
                else 
                    return t.substring(i).equals(s.substring(i+1));//s更长只能删s
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
        //如果前面都一样，，还有种情况 abc abccc所以要判断两者长度是否为1
    }
}

***************************************************************************
72.
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
O(mn)  O(mn)
**************************************************************************
class Solution {
  public int minDistance(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    // if one of the strings is empty
    if (n * m == 0)
      return n + m;

    // array to store the convertion history
    int [][] d = new int[n + 1][m + 1];

    // init boundaries
    for (int i = 0; i < n + 1; i++) {
      d[i][0] = i;
    }
    for (int j = 0; j < m + 1; j++) {
      d[0][j] = j;
    }

    // DP compute 
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        int left = d[i - 1][j] + 1;
        int down = d[i][j - 1] + 1;
        int left_down = d[i - 1][j - 1];
        if (word1.charAt(i - 1) != word2.charAt(j - 1))
          left_down += 1;
        d[i][j] = Math.min(left, Math.min(down, left_down));

      }
    }
    return d[n][m];
  }
}
