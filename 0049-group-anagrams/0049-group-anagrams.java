class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) 
            return new ArrayList();
        HashMap<String,List<String>> hm = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(String str: strs )       
        {
            char[] chars= str.toCharArray();
            Arrays.sort(chars);
            String key=String.valueOf(chars); 
            if(!hm.containsKey(key))
            {
                hm.put(key,new ArrayList<String>());
            }
            
            hm.get(key).add(str);
        }
        
        return new ArrayList(hm.values());
    }
}