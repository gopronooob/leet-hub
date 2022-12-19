class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int ans[] = new int[m+n];
        int walker1=0;
        int walker2=0;
        int index=0;
        while(walker1<m && walker2<n)
        {
            if(nums1[walker1]<nums2[walker2])
            {
                ans[index++] = nums1[walker1];
                walker1++;
            }
            else
            {
                ans[index++]=nums2[walker2];
                walker2++;
            }
        }
        
        while(walker1<m)
        {
                ans[index++] = nums1[walker1];
                walker1++;
        }
        
        while(walker2<n)
        {
            ans[index++]=nums2[walker2];
                walker2++;
        }

        for(int x =0 ;x<ans.length;x++){
            nums1[x]=ans[x];
        }

   //  return ans;   
    }
}