Two strings are given, we need to find whether we can form second string by swapping the character of the first string.
*****************************************************************
piublic class Solution { 
    static int MAX = 26; 
    static bool targetstring(string str1, string str2) { 
        int l1 = str1.Length; 
        int l2 = str2.Length; 
        // if length is not same print no 
        if (l1 != l2) 
            return false; 
      
        int []map = new int[MAX]; 
      
        // Count frequencies of character in first string. 
        for (int i = 0; i < l1; i++) 
            map[str1[i] - 'a']++; 
      
        // iterate through the second string decrement counts of characters in second string 
        for (int i = 0; i < l2; i++) { 
            map[str2[i] - 'a']--; 
      
            // Since lengths are same, some value would definitely become negative if result is false. 
            if (map[str2[i] - 'a'] < 0) 
                return false; 
        } 
        return true; 
    } 
} 
  
