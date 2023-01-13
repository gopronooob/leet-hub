class Solution {
public String minWindow(String s, String t) {
    int m = s.length(), n = t.length(), count = 0, minWindow = Integer.MAX_VALUE;;
    String res = "";
    int left = 0 ,right = 0;
    Map<Character, Integer> mapS = new HashMap<>();
    Map<Character, Integer> mapT = new HashMap<>();
    
    for (char c : t.toCharArray()) 
        mapT.put(c, mapT.getOrDefault(c, 0) + 1);
    
    while ( right < m) {
        mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0) + 1);
        
        if (mapT.containsKey(s.charAt(right)) && mapS.get(s.charAt(right)) <= mapT.get(s.charAt(right))) 
            count++;
        while (count == n) {
            if (minWindow > right - left + 1) {
                minWindow = right - left + 1;
                res = s.substring(left, right + 1);
            }
            
            char curr = s.charAt(left);
            
            if (mapS.get(curr) == 1) mapS.remove(curr);
            else mapS.put(curr, mapS.get(curr) - 1);
            
            left++;
            
            if (mapT.containsKey(curr) && mapS.getOrDefault(curr, 0) < mapT.get(curr)) count--;
        }
        right++;
    }
    return res;
}
}