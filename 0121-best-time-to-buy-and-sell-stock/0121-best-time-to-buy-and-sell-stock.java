class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int buy=0;
            for(int sell=buy+1;sell<prices.length;sell++)
            {
                if(prices[sell]>prices[buy])
                    ans=Math.max(ans,prices[sell]-prices[buy]);
                if(prices[sell]<prices[buy])
                    buy=sell;
            }
        
        return ans;
    }
}