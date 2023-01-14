class Solution {
    public String longestPrefix(String s) {
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        int lps[] = computeLPSArray(s);
        
        return s.substring(0,lps[s.length() - 1]);
    }
    
    public static int[] computeLPSArray(String pat) {
        int i=0;
        int j=1;
        int size=pat.length();
        int[] LPS=new int[size];
        
        while(j<size)
        {
            if(pat.charAt(i)==pat.charAt(j))
            {
                LPS[j]=i+1;
                i++;
                j++;
            }
            else
            {
                if(i!=0)
                {
                    i=LPS[i-1];
                }
                else
                { 
                    LPS[j]=i;
                    j++;
                }
            }
        }
        return LPS;
    }
}