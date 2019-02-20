class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}
***********************************************************
class resultType {
    int[] point;
    int count;
    public resultType(int count){
        point = new int[2];
        this.count = count; 
    }
    public String toString(){
        return point + " " + count;
    }
}
public class robotMap{
     public static resultType[] robotMap(String[] commands){
         Map<int[], Integer> map = new HashMap<>();
         int[] coordinate = new int[2];
         for (String command : commands){
             if (command.equals("up")){
                 coordinate[1] += 1;
             } else if (command.equals("down")){
                 coordinate[1] -= 1;
             } else if (command.equals("left")){
                 coordinate[0] -= 1;
             } else {
                 coordinate[0] += 1;
             }
                map.put(coordinate, map.getOrDefault(coordinate, 0) + 1);
         }
         resultType[] res = new resultType[map.size()];
         int i = 0;
         for (int[] key : map.keySet()){
            res[i].point = key;
            res[i].count = map.get(key);
            i++;
         }
         return res;
     } 
     public static void main(String []args){
        String[] commands = {"up", "up", "up", "up"};
        System.out.println(robotMap(commands).toString());
     }
}
