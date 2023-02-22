class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int i=0, j=0, n=nums.length; 
        Deque<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> ans =new ArrayList<>();
        
        while (j<n) {
            while(!queue.isEmpty() && queue.peekLast()<nums[j])
                queue.removeLast();
            queue.addLast(nums[j]);
            if(j-i+1<k)
            {
                j++;
            }
            else
            {
                if(queue.isEmpty())
                {
                    ans.add(0);
                }
                else
                {
                    ans.add(queue.peekFirst());                    
                }
                if(queue.peekFirst()==nums[i])
                    queue.removeFirst();
                
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(x->x).toArray();       
                       
        }
        
    
}