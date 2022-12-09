class Solution {
    public int trap(int[] height) {
        
        int[] greaterToLeft = new int[height.length];
        int[] greaterToRight = new int[height.length];
        
        greaterToLeft[0] = height[0];
        
        for(int i=1;i<height.length;i++)
        {
            greaterToLeft[i] = Math.max(greaterToLeft[i-1],height[i-1]);
        }
            
        
        for(int i=height.length-2;i>=0;i--)
        {
            greaterToRight[i] = Math.max(greaterToRight[i+1],height[i+1]);
        }
        
        int ans=0;
        for(int i=0;i<height.length;i++)
        {
            int cur=Math.min(greaterToRight[i],greaterToLeft[i])-height[i];
            if(cur>0)
            ans+= cur;
        }
            return ans;
    }
}