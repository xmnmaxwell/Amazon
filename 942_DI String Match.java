class Solution {
    public int[] diStringMatch(String S) {
        int index = 0;
        int start = 0;
        int end = S.length();
        int[] res = new int[S.length()+1];
        
        for (char c : S.toCharArray()){
            if (c == 'I') res[index++] = start++;
            else if (c == 'D') res[index++] = end--;
        }
        res[index] = start;
        return res;
    }
}
