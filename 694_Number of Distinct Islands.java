require number of different islands
****************************************************************************
class Solution {
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        Set<List<List<Integer>>> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j <grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<List<Integer>> ls = bfs(grid, i, j);
                    set.add(ls);
                }
            }
        }
        return set.size();
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    List<List<Integer>> bfs(int[][] grid, int a, int b){
        List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        qx.offer(a);
        qy.offer(b);
        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            List<Integer> ls = new ArrayList<>();
            ls.add(x - a);
            ls.add(y - b);
            res.add(ls);
            for(int i = 0; i < 4; i++){
                int nx = x +dx[i];
                int ny = y + dy[i];
                if(nx >= 0 &&nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1){
                    grid[nx][ny] = 0;
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }
        return res;
    }
}
