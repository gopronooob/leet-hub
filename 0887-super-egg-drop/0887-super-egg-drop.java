class Solution {
    public int superEggDrop(int k, int n) {
       /* int[][] dp = new int[k+1][n+1];
        for(int []col:dp)
        {
            Arrays.fill(col,-1);
        }
        return funMemo(k,n,dp);
        */
        Integer[][] dp= new Integer[k+1][n+1];
        return eggCount(k,n,dp);
    }
    
    int eggCount(int eggs,int floor,Integer[][] dp)
    {
        int f=floor;
        int e=eggs;
        
        if(dp[eggs][floor]!=null) return dp[eggs][floor];
        if(eggs==1)
            return floor;
        if(floor ==0 || floor ==1)
            return floor;
               int min = Integer.MAX_VALUE, low = 0, high = f;
        while (low <= high) {
            int mid = (low + high) / 2;
            int l = 0, h = 0;
            if (dp[e-1][mid-1] != null) {
                l = dp[e-1][mid-1];
            } else {
                l = eggCount(e-1, mid - 1, dp);
                dp[e-1][mid-1] = l;
            }
            if (dp[e][f-mid] != null) {
                h = dp[e][f-mid];
            } else {
                h = eggCount(e, f - mid, dp);
                dp[e][f-mid] = h;
            }
            
            if (l < h) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            int temp = 1 + Math.max(l, h);
            min = Math.min(min, temp);
        }
        return dp[e][f] = min;

    }
    
    
static int funMemo(int egg, int floor, int[][] memo) {
        if (floor == 0 || floor == 1)
            return floor;

        if (egg == 1)
            return floor;

        if (memo[egg][floor] != -1)
            return memo[egg][floor];

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= floor; k++) {

            int down, top;

            if (memo[egg - 1][k - 1] != -1) {
                down = memo[egg - 1][k - 1];
            } else {
                down = funMemo(egg - 1, k - 1, memo);
            }

            if (memo[egg][floor - k] != -1) {
                top = memo[egg][floor - k];
            } else {
                top = funMemo(egg, floor - k, memo);
            }

            int temp = 1 + Math.max(down, top);

            if (min > temp)
                min = temp;
        }
        memo[egg][floor] = min;
        return min;
    }


    
}