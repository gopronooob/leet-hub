class Solution {
    int islands=0;
    public int numIslands(char[][] grid) {
        
        if(grid==null) return 0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    islands++;
                    colorIsland(grid,i,j);
                }
            }
        }
        return islands;
    }
    
    
    void colorIsland(char[][]island,int row,int col)
    {
        if(row<0 || col < 0 || row >=island.length || col >= island[0].length || island[row][col]!='1' )
        {
            return;
        }
        
        island[row][col]=2;
        
        colorIsland(island,row+1,col);
        colorIsland(island,row,col+1);
        colorIsland(island,row-1,col);
        colorIsland(island,row,col-1);
    }
}