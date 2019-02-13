Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
头文件字母数字混合，但后面的一定全是数字或全是字母，把字母的按排序放前面，数字的保持顺序不变
*********************************************************************************
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return logs;
        int len = logs.length;
        List<String> letterList = new ArrayList<>();// create list for 只有字母的log
        List<String> digitList = new ArrayList<>();// create list for 只有数字的log
        for (String log : logs) {
            if (log.split(" ")[1].charAt(0) < 'a') {
                digitList.add(log); //放数字的log
            } else {
                letterList.add(log);//放字母的log
            }
        }
        Collections.sort(letterList, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");
            int len1 = s1.length;
            int len2 = s2.length;
            for (int i = 1; i < Math.min(len1, len2); i++) {
                if (!s1[i].equals(s2[i])) {
                    return s1[i].compareTo(s2[i]);//按字母的升序
                }
            }
            return 0;
        });

        for (int i = 0; i < len; i++) {
            if (i < letterList.size())
                logs[i] = letterList.get(i);//把字母的log放前面
            else logs[i] = digitList.get(i - letterList.size()); //把数字的log放后面
        }
        return logs;
    }
}
