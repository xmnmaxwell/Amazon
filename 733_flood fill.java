Input: 
image = [[1,1,1],
         [1,1,0],
         [1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],
         [2,2,0],
         [2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
************************************************************************
//O(mn) O(mn)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) return image;
        int oldColor = image[sr][sc];
        if (oldColor != newColor) helper(image, sr, sc, oldColor, newColor);
        return image;
    }
    public void helper(int[][] image, int r, int c, int oldColor, int newColor){
        if (image[r][c] == oldColor){
            image[r][c] = newColor;
            if (r >= 1) helper(image, r-1, c, oldColor, newColor);
            if (c >= 1) helper(image, r, c-1, oldColor, newColor);
            if (r < image.length - 1) helper(image, r+1, c, oldColor, newColor);
            if (c < image[0].length - 1) helper(image, r, c+1, oldColor, newColor);
        }
    }
}
