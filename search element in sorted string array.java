public class Solution{
     public static boolean compareString(String str1, String str2){
         int i = 0;
         while (str1.charAt(i) == str2.charAt(i)) {
             i++;
         }
         return (str1.charAt(i) > str2.charAt(i));
     }
     public static int findTarget(String[] str, String target){
         int start = 0, end = str.length;
         while (start + 1 < end) {
             int mid = start + (end - start)/2;
             if (str[mid].equals(target)) return mid;
             else if (compareString(str[mid], target)) {
                 end = mid;
             } else {
                 start = mid;
             }
         }
         if (str[start].equals(target)) return start;
         else if (str[start].equals(target)) return end;
         return -1;
     }
     public static void main(String []args){
         String[] str = {"abc", "bcd", "eds", "zxc"};
         String target = "eds";
        System.out.println(findTarget(str, target));
     }
}
