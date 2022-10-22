class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
                Set<String> words = new HashSet<>(wordList);

        if(!wordList.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
                Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int ans=0;
        while(!q.isEmpty())
        {
            int qSize= q.size();
            for(int i=0;i<qSize;i++)
            {
                String current = q.remove();
                if(endWord.equals(current)) return ans+1;
                for(int j=0;j<current.length();j++)
                {
                    char[] currentWordChar= current.toCharArray();
                    for(char ch= 'a' ; ch <='z' ; ch++)
                    {
                       // if(ch== current.charAt(j)) continue;
                        currentWordChar[j]=ch;
                        
                        String newWord=String.valueOf(currentWordChar);
                        //if(endWord.equalsIgnoreCase(newWord)) return ans+1;
                        if(words.contains(newWord) && !visited.contains(newWord)) {
                            q.add(newWord);
                            visited.add(newWord);
                        }
                    }
                }
                
                //wordList.remove(current);
            }

            ans++;
        }
        
        return 0;
    }
     
}