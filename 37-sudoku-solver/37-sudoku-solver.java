class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0)
            return;
        
        solve(board);
    }
    
    
    public boolean solve(char[][] board) {
     
        for(int row=0;row<9;row++)
        {
            for(int col=0;col<9;col++)
            {
                if(board[row][col]=='.')
                {
                    for(char ch='1';ch<='9';ch++)
                    {
                        if(isValid(row,col,ch,board))
                        {
                            board[row][col]=ch;
                           /* solve(board);
                            board[row][col]='.';*/
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(int row ,int col,char ch,char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==ch || board[i][col]==ch) return false;            
        }
        
        for(int r=(row/3)*3;r<((row/3)*3)+3;r++)
        {
            for(int c=(col/3)*3;c<((col/3)*3)+3;c++)
            {
                if(board[r][c]==ch)return false;
            }
            
        }
        
        return true;
    }

}