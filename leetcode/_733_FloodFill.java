public class _733_FloodFill{
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int col = image[sr][sc];
       if(col != newColor)
           dfs(image, sr, sc, col, newColor);
       return image;
   }
   public void dfs(int[][] image, int r, int c, int color, int newColor){
       if(image[r][c] == color){
           image[r][c] = newColor;
           if (r >= 1)
               dfs(image, r-1, c, color, newColor);
           if (c >= 1)
               dfs(image, r, c-1, color, newColor);
           if (r+1 < image.length)
               dfs(image, r+1, c, color, newColor);
           if (c+1 < image[0].length)
               dfs(image, r, c+1, color, newColor);
       }
   }
}
