Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
********************************************************************************************************************
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        
        String[] str = path.split("/");// 把字符串分割成只含有"","..","."和文件路径的字符串数组
        for(String s : str){
            if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop(); //如果他的前置文件路径是遇到..，他的前置文件路径就要被pop掉
            } else if (!s.equals(".") && !s.equals("")){
                stack.push(s);//遇到没有"","."的说明是正常路径
            }
        }
        
        String res = "";
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) return "/";
        return res;
    }
}
