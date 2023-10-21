class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int i=0;
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[j]>prices[i])
                    ans=Math.max(ans,prices[j]-prices[i]);
                if(prices[j]<prices[i])
                    i=j;
            }
        
        return ans;
    }
}