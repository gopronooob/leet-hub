class Solution {
    public String reorganizeString(String s) {
        if(s.length()<1)
            return "";
        int maxFreq=0;
        char mostFreq=s.charAt(0);
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray())
        {
            int frequency  = map.getOrDefault(ch,0);
            frequency+=1;
            if(maxFreq<frequency)
            {
                maxFreq=frequency;
                mostFreq=ch;
            }
            if(2*maxFreq-1>s.length()) return "";
            map.put(ch,frequency);
        }
        
        char[] ans = new char[s.length()];
        int walker = 0 ;
        while(map.get(mostFreq)>0)
        {
            ans[walker]=mostFreq;
            walker+=2;
            map.put(mostFreq,map.get(mostFreq)-1);
        }
            
        for(char ch:s.toCharArray())
        {
            while(map.get(ch)>0)
            {
                if(walker>=s.length())
                    walker=1;
                ans[walker]=ch;
                walker+=2;
                map.put(ch,map.get(ch)-1);
            }
        }
        
        for(int i=1;i<ans.length;i++)
        {
            if(ans[i-1]==ans[i])
                return "";
        }
        
        return String.valueOf(ans);
    }
}