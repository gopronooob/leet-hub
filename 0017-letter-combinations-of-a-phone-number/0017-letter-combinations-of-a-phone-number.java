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
            List<String> cur = new ArrayList<>();
            return cur;
        }
        
        String num = String.valueOf(digits.charAt(0));
        String remaining = digits.substring(1);
        
        List<String> existingWords=letterCombinations(remaining);
        List<String> currentWords = new ArrayList<>();
        String charList = phone.get(num);
       for(int i=0;i<charList.length();i++){
            if(existingWords.size()==0)
            {
                currentWords.add(String.valueOf(charList.charAt(i)));
            }
            else
            {
                for(String word:existingWords)
                {
                    currentWords.add(charList.charAt(i)+word);
                }
            }
         }
        
        return currentWords;
    }
}