//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    int search(String pat, String txt) {
        // code here
        int left=0;
        int right=0;
        int ans=0;
        
        HashMap<Character,Integer> pattern = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char ch:pat.toCharArray())
        {
            pattern.put(ch,pattern.getOrDefault(ch,0)+1);
        }
        while(right<txt.length())
        {
            window.put(txt.charAt(right),window.getOrDefault(txt.charAt(right),0)+1);
            
            if(right-left+1<pat.length())
            {
                right++;
            }
            else if(right-left+1==pat.length())
            {
                if(areAnagram(pattern,window))
                    ans++;
                
                window.put(txt.charAt(left),window.getOrDefault(txt.charAt(left),0)-1);
                left++;
                right++;
            }
        }
        
        return ans;
    }
    
    public boolean areAnagram(HashMap<Character,Integer> pattern,HashMap<Character,Integer> window)
    {
       // System.out.println(pattern+" "+window);
        for(char ch:pattern.keySet())
        {
            if(!pattern.get(ch).equals(window.get(ch)))
                return false;
        }
        return true;
    }
}