Input: ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails
+： 指+后面@前面的东西可以去除， .： 指@前的.可以省略
*********************************************************************************************************************
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email: emails){
            String[] part = email.split("@");// split into part[0] local and part[1] domain;
            String[] local = part[0].split("\\+"); // split +;
            local[0] = local[0].replace(".", "");//为什么不能用replaceAll?
            set.add(local[0] + "@" + part[1]);
        }
        return set.size();
    }
}
