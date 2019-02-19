Given two words (beginWord and endWord), and a dictionary's word list, 
find the length of shortest transformation sequence from beginWord to endWord
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
*****************************************************************************************
class Solution {
    //大致的过程就是
    // hit --> hot --> dot, lot --> (dog, lot), log -->cog(和最末单词比较是一致的返回5)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        Set<String> dict = new HashSet<>();
        for (String word : wordList){
            dict.add(word);
        } // 把单词放进去dict里
        
        HashSet<String> set = new HashSet<>();//用来放所有演变的单词
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        set.add(beginWord);
        
        int len = 1;
        while(!q.isEmpty()){
            len++;
            int size = q.size();
            for (int i = 0; i < size; i++){
                String word = q.poll();
                for(String nextWord : getNextWord(word, dict)){
                    if(set.contains(nextWord)) continue;//如果set已经含有了这个单词跳过
                    if(nextWord.equals(endWord)) return len;//如果和目标单词一样说明找到了，返回长度
                    
                    set.add(nextWord); //都是不的话把单词放进set里
                    q.offer(nextWord);//队列里也加入这个单词
                }
            }
        }
        return 0;
    }
    private ArrayList<String> getNextWord(String word, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++){
            for (int i = 0; i < word.length(); i++){
                if (c == word.charAt(i)) continue;// find first element 
            String nextWord = replace(word, i, c);
            if (dict.contains(nextWord)){
                nextWords.add(nextWord);
            }
        }
        }
        return nextWords;
    }
    private String replace(String s, int index, char c){
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
*****************************************************************************************
126.  The basic idea is:

1). Use BFS to find the shortest distance between start and end, tracing the distance of crossing nodes from start node to end node, and store node's next level neighbors to HashMap;
2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap: compare if the distance of the next level node equals the distance of the current node + 1.
