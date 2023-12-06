class Solution {
    public int totalMoney(int n) {
        int ans=0;
        int week=1;
        int monday = 1;
        while(n>0 )
        {
            for(int day=0;day<Math.min(n, 7);day++)
            {
                ans += monday+day;
            }
            monday++;
            n-=7;
        }
        
        return ans;
    }
}