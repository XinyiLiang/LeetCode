/*  We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including 
 * multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 * 
 * Now say a word a from A is universal if for every b in B, b is a subset of a. 
 * 
 * Return a list of all universal words in A.  You can return the words in any order.
 * 
 * Example 1:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 * 
 * Example 2:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
 * Output: ["apple","google","leetcode"]
 * 
 * Example 3:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
 * Output: ["facebook","google"]
 * 
 * Example 4:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
 * Output: ["google","leetcode"]
 * 
 * Example 5:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
 * Output: ["facebook","leetcode"]
 *
 * Note:
 *
 * 1 <= A.length, B.length <= 10000
 * 1 <= A[i].length, B[i].length <= 10
 * A[i] and B[i] consist only of lowercase letters.
 * All words in A[i] are unique: there isn't i != j with A[i] == A[j].
*/



class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<String>();
        
        int[] Bcount = new int[26];
        
        for(int j = 0; j<B.length; j++)
        {
            int[] bcount = new int[26];
                  for( int i = 0; i< B[j].length(); i++)
                  {
                      bcount[B[j].charAt(i)-'a']++;
                      if(bcount[B[j].charAt(i)-'a'] > Bcount[B[j].charAt(i)-'a'])
                      {
                          Bcount[B[j].charAt(i)-'a']++;
                          
                      }
                  }
        }
        
     
        for( int i=0; i<A.length; i++)
        {
            boolean sub = true;
            
            int[] acount = new int[26];
                  for( int a = 0; a< A[i].length(); a++)
                  {
                      acount[A[i].charAt(a)-'a']++;
                  }    
            
             for(int j = 0; j<26; j++)
                {
                  if(acount[j]< Bcount[j])
                     {
                          sub = false;
                          break;
                     }
                    
                 } 
            
            if(sub)
                ans.add(A[i]);
        }
        return ans;
    }
}
