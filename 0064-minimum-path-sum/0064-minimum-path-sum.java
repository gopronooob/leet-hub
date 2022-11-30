class Solution {
    public int minPathSum(int[][] grid) {
        
        int[][] dp = new int[grid.length+1][grid[0].length+1];
         
            Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        
        return helper(grid,0,0,dp);
    }
    
    public static int helper(int[][] grid,int row,int col,int[][] dp)
    {
        if(row==grid.length-1 && col == grid[0].length-1)
            return grid[row][col];
        
        if(row>=grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;
        
        if(dp[row][col]!=-1)
            return dp[row][col];
        
        dp[row][col]=Math.min(helper(grid,row+1,col,dp) , helper(grid,row,col+1,dp))+grid[row][col];
        
        return dp[row][col]; 
    }
}