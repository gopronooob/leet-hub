class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int prev=0;
        int next=1;
        int profit=0; 
        while(next<prices.length)
        {
            if(prices[prev]>prices[next])
            {
                prev++;
                next++;     
                continue;
            }
              
                profit+=prices[next]-prices[prev];
                prev++;
                next++;  
        }       
        return profit;
    }/*
class Solution {
    public int maxProfit(int[] prices) {
        
        
        int profit=0;
        int buy=prices[0];
        int sell=prices[0];
        
        for(int i=1;i<prices.length;i++)
        {
            //System.out.println(prices[i]+" "+buy+ " "+sell);
            if(prices[i]<buy)
            {
                buy=prices[i];
            }
            if(prices[i]>buy)
            {
                sell=prices[i];
                profit+=sell-buy;
                buy=prices[i];
            }
        }
        return profit;
    }
}*/
}
