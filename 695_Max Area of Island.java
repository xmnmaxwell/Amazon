Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
O(RC) + O(RC)
*************************************************************
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(grid[i][j] == 1) 
                maxArea = Math.max(maxArea, area(grid, i, j, m, n));
            }
        }
        return maxArea;
    }
    
    private int area(int[][] grid, int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
            grid[i][j] = 0;//已经算过的设置为0
            return 1 + area(grid, i+1, j, m, n) + area(grid, i-1, j, m, n) + area(grid, i, j+1, m, n) + area(grid, i, j-1, m, n);
        }
       return 0; 
    }
}
