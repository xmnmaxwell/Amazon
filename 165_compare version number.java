Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:
Input: version1 = "1.0.1", version2 = "1"
Output: 1
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
*************************************************************
class Solution {
    public int compareVersion(String version1, String version2) {
        //1、如果用“.”作为分隔的话,必须是如下写法,String.split("\\."),这样才能正确的分隔开,不能用String.split(".");

//2、如果用“|”作为分隔的话,必须是如下写法,String.split("\\|"),这样才能正确的分隔开,不能用String.split("|");

//“.”和“|”都是转义字符,必须得加"\\";

//3、如果在一个字符串中有多个分隔符,可以用“|”作为连字符,比如,“acount=? and uu =? or n=?”,把三个都分隔出来,可以用String.split("and|or");
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i = 0; i < Math.max(v1.length, v2.length); i++){
            int a = i < v1.length ? Integer.valueOf(v1[i]) : 0;
            int b = i < v2.length ? Integer.valueOf(v2[i]) : 0;
            if (a < b)
                return -1;
            else if (a > b)
                return 1;
        }
        return 0;
    }
}
