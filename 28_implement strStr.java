Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Input: haystack = "hello", needle = "ll"
Output: 2
Go over the original string, compare each element as a start 
********************************************************************************
O(mn)
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        for (int i = 0; i < haystack.length(); i++){
           if (i+needle.length()>haystack.length()) return -1; // if the length is not correct, return
            int m = i;
                for (int j = 0; j< needle.length(); j++){
                    if (haystack.charAt(m) == needle.charAt(j)){ // keep searching if char is the same, return if not
                        if (j == needle.length() -1){ // if match, compare the length, if true return index.
                            return i;
                        } 
                        m++;
                    } else {
                        break;
                    }
                }
            }
           return -1;
    }
}
