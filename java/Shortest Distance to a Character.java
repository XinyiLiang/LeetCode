/* Given a string s and a character c that occurs in s, return an array of integers answer where 
 * answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 *
 * Example 1:
 * Input: s = "loveleetcode", c = "e"
 * Output: [3,2,1,0,1,0,0,1,2,2,1,0]
 * 
 * Example 2:
 * Input: s = "aaab", c = "b"
 * Output: [3,2,1,0]
 *
 * 
 * Constraints:
 * 1 <= s.length <= 104
 * s[i] and c are lowercase English letters.
 * c occurs at least once in s.
 */


class Solution {
    public int[] shortestToChar(String s, char c) {
        
        int len = s.length();
        int[] ans = new int[len];
        
        Integer FrontIndex = s.indexOf(c);
        Integer BackIndex =  null;
     
        for(int i =0; i<len; i++)
        {
            
            if(BackIndex !=  null && i>FrontIndex && i< BackIndex)
            {
                ans[i] = i-FrontIndex > BackIndex-i ? BackIndex-i : i-FrontIndex;
            }
            else if (i == FrontIndex)
            {
                ans[i]=0;
                if(s.indexOf(c, FrontIndex+1) != -1)
                   BackIndex = s.indexOf(c, FrontIndex+1);
                
            }
            else if(BackIndex ==  null )
                ans[i] = Math.abs(i-FrontIndex);
            else if (i == BackIndex)
            {
                ans[i]=0;
                FrontIndex = BackIndex;
                if(s.indexOf(c, BackIndex+1) != -1)
                    BackIndex =s.indexOf(c, BackIndex+1);
                else
                    BackIndex =null;
                
            }
        }
        
        return ans;
    }
}
