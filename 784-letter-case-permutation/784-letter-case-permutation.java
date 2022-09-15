class Solution {
        List<String> ans=new ArrayList<>(); 
    public List<String> letterCasePermutation(String s) {
        
        if(s==null || s.length() ==0)
        {
            return ans;
        }
        
        String stringSoFar="";
        backTrack(s,stringSoFar);
        return ans;
    }
    
    public void backTrack(String s , String stringSoFar)
    {
        if(s.length()==0)
        {
            ans.add(stringSoFar);
            return;
        }
        
        if(Character.isDigit(s.charAt(0)))
        {
            stringSoFar=stringSoFar+s.charAt(0);
            s=s.substring(1);
            backTrack(s,stringSoFar);
        }
        else
        {
            String s1=stringSoFar+Character.toUpperCase(s.charAt(0));
            String s2=stringSoFar+Character.toLowerCase(s.charAt(0));
            s=s.substring(1);
            backTrack(s,s1);
            backTrack(s,s2);
        }
    }
}