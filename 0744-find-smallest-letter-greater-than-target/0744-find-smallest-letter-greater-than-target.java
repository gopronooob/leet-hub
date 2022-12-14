class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        int size=letters.length;
        int start =0 ;
        int end = size-1;
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            
            if (letters[mid] <= target)
                start=mid+1;
            else
                end=mid-1;
        }
        
        start = start%size;
        return letters[start];
    }
}