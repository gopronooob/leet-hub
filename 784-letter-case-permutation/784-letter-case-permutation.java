class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        if(s == null || s.length() == 0)
        {
            return ans;
        }
        String stringSoFar="";
        helper(s,stringSoFar);
        return ans;
    }
    
    public void helper(String st,String ssf)
    {
        if(st.length()==0)
        {
            ans.add(ssf);
            return; 
        }
        
        if(Character.isDigit(st.charAt(0)))
        {
            ssf=ssf+st.charAt(0);
            st=st.substring(1);
            helper(st,ssf);
        }
        else
        {
            String ssf1=ssf+Character.toUpperCase(st.charAt(0));
            String ssf2=ssf+Character.toLowerCase(st.charAt(0));
            st=st.substring(1);
            helper(st,ssf1);
            helper(st,ssf2);
        }
    }
}