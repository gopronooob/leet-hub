/*
    breadth first search 
    first traverse and add all rotten in queue
    later for each neighbor from queue rot orange , if able to rot orange , then decrease fresh count 
    if increase count depth wise
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count_fresh = 0;
        //Put the position of all rotten oranges in queue
        //count the number of fresh oranges
        for(int i = 0 ; i < rows ; i++) {
            for(int j = 0 ; j < cols ; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i , j});
                }
                else if(grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        
        //if count of fresh oranges is zero --> return 0 
        if(count_fresh == 0) return 0;
        int count = 0;

        
        while(!queue.isEmpty())
        {
            int len=queue.size();
            
            for(int i=0;i<len;i++)
            {
                int[] point = queue.poll();
                int x=point[0];
                int y=point[1];
                
                if(rotOrange(x+1,y,grid))
                   { queue.offer(new int[]{x+1,y});
                   count_fresh--;
                   }
                
                if(rotOrange(x-1,y,grid))
                    {queue.offer(new int[]{x-1,y});
                    count_fresh--;
                    }
                
                if(rotOrange(x,y+1,grid))
                    {queue.offer(new int[]{x,y+1});
                    count_fresh--;
                    }
                
                if(rotOrange(x,y-1,grid))
                    {queue.offer(new int[]{x,y-1});
                    count_fresh--;
                    }
                                
            }
            
            count++;
        }
        //System.out.println(count_fresh+" "+count);
         return count_fresh == 0 ? count-1 : -1;
    }
    
    
    boolean rotOrange(int x,int y,int[][] grid)
    {
        if(x<0 || x>=grid.length || y<0 || y >= grid[0].length ||grid[x][y]==2 || grid[x][y]==0 )
            return false;
        grid[x][y]=2;
        return true;
    }
}


