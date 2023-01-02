class Solution {
    public int findPairs(int[] nums, int k) {
        
        int ans=0;
        HashMap<Integer,Integer> set= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            set.put(nums[i],set.getOrDefault(nums[i],0)+1);
        }
        
        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() >= 2) {
                    ans++;
                } 
            } else {
                if (set.containsKey(entry.getKey() + k)) {
                    ans++;
                }
            }
        }

        
//        Arrays.stream(nums).distinct().forEach( i-> {
        
//             if(k==0)
//             {
//                 if(set.get(i)>=2)
//                 {
//                     ans++;
//                 }
//             }  else
//                 {
//                     if(set.getOrDefault(i+k,0)>0)
//                     {
//                         ans++;
//                     }
//                 }
//             }
//         );
        return ans;
    }
}