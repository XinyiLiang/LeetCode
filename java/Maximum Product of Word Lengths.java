/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

 

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
*/


class Solution {
    public int maxProduct(String[] words) {
        
        List<int[]> list = new ArrayList<int[]>();
        int len = words.length;
       
        for(int i=0; i<len; i++)
        {
            int[] count = new int[26];
           for(char c: words[i].toCharArray())
           {
               count[c-'a']++;
           }
            list.add(count);
        }
        
        int maxProduct = 0; 
        
        for(int i=0; i<len; i++)
        {
            for(int j=i+1; j<len; j++)
            {
                int sum =  hasCommon(list.get(i), list.get(j));
                
                if( sum != -1)
                {
                    maxProduct = Math.max(sum, maxProduct);
                   
                } 
            }
        }
        
        return maxProduct;
        
        
    }
    
    
    public int hasCommon(int[] a,int[] b){
       
        int total = 0; 
        int acount = 0; 
        int bcount = 0; 
        for(int i=0; i<26; i++)
        {
            if( a[i] !=0 && b[i]!=0)
                return -1;
            
              acount  = a[i] != 0 ? acount +a[i] : acount ;
              bcount  = b[i] != 0 ? bcount +b[i] : bcount ;
            
        }
        
        return acount * bcount ;
    }
}
