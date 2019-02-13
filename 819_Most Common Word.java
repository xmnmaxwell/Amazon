class Solution {
    //Amazon
    public String mostCommonWord(String paragraph, String[] banned) {
       String[] para = paragraph.toLowerCase().split("[!?',;. ]+");//split
        //[]+ 表示所有在方括号里的东西都要删掉
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : para){
            map.put(word, map.getOrDefault(word, 0)+1);//put word in hashmap and its count
        }
        for (String word : banned){
            if (map.containsKey(word))
                map.remove(word);// remove banned word
        }
        String res = null;
        for(String word : map.keySet()){
            if (res == null || map.get(word) > map.get(res))//if res is null or < other's count, res change to that element
                res = word;
        }
        return res;
    }
}
