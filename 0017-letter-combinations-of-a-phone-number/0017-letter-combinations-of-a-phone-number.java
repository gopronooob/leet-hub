class Solution {
    
      Map<String, String> phone = new HashMap<String, String>() {{
    put("2", "abc");
    put("3", "def");
    put("4", "ghi");
    put("5", "jkl");
    put("6", "mno");
    put("7", "pqrs");
    put("8", "tuv");
    put("9", "wxyz");
  }};
    
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            {
                List<String> cur=new ArrayList<>();
               // cur.add("");
                return cur;            
            }
        
        List<String> ret= letterCombinations(digits.substring(1));
        List<String> answer=new ArrayList<>();
        String ch= String.valueOf(digits.charAt(0));
        String charSet=phone.get(ch);
        
        for(int i=0;i<charSet.length();i++){ 
        if(ret.size()==0)
        {
            answer.add(String.valueOf(charSet.charAt(i)));
        }
        for(String word:ret)
        { 
            answer.add(charSet.charAt(i)+word);
            
        }
        }
        return answer;
    }
}