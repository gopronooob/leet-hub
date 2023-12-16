class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length() != t.length())
            return false;
        
        Map<Character,Integer> countOne= new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            countOne.put(s.charAt(i),countOne.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(int i=0;i<s.length();i++)
        {
            countOne.put(t.charAt(i),countOne.getOrDefault(t.charAt(i),0)-1); 
        }
        
        for(Character ch:countOne.keySet())
        {
            if(countOne.get(ch)!=0)
                return false;
        }
        
        return true;
    }
}