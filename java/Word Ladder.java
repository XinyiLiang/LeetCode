class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        if(wordList.indexOf(endWord) == -1)
            return 0;
        
        Queue<String> queue = new LinkedList<String>();
        
        queue.offer(beginWord);
        
        int count = 1;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
           
            for(int i = 0; i< size; i++)
            {
                String currentWord = queue.poll();
                                
                if(diff(currentWord, endWord) == 0) return count ;
                
                
                  for(int k=0; k< wordList.size(); k++)
                  {
                 
                       if ( diff(currentWord, wordList.get(k)) == 1 )
                        {
                            queue.offer(wordList.get(k));
                            wordList.remove(k);
                            k--;
                        } 
                  }
                    
            }
            
            count++;
            
        }
        
        return 0;
    }
    
    
    public int diff(String s1, String s2)
    {
        int count = 0;
        for( int i = 0; i<s1.length();i++)
        {
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        
        return count;
    }
}
