class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        if(n==0)
            return ans;
        boolean board[][]=new boolean[n][n];
        placeQueens(n,ans,0,new ArrayList<String>(),board);
        return ans;
    }
    
    public void placeQueens(int n,List<List<String>> ans,int row,ArrayList<String> qsf,boolean[][] board){
        if(row==n)
        {
            ans.add(new ArrayList(qsf));
            return;
        }
        
       for(int col=0;col<n;col++)
       {
           if(isQueenSafe(board,row,col)){
               board[row][col]=true;
               char[] charArray=new char[n];
               Arrays.fill(charArray,'.');
               charArray[col]='Q';
               qsf.add(new String(charArray));
               placeQueens(n,ans,row+1,qsf,board);
               board[row][col]=false;
               qsf.remove(qsf.size()-1);
           }
       }
    }
    public static boolean isQueenSafe(boolean[][] board,int row,int col)
              {
                  
                  for(int i=row-1, j=col;i>=0;i--)
                  {
                      if(board[i][j]==true)
                          return false;
                  }
                  
                  for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--)
                  {
                      if(board[i][j]==true)
                          return false;
                  }
                  for(int i=row-1, j=col+1;i>=0 && j<board.length;i--,j++)
                  {
                      if(board[i][j]==true)
                      {
                          return false;
                      }
                  }
                  
                  return true;
              }
}