/* Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * 
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case)
 */
 
class Solution {
    public String longestPalindrome(String s) {
        
        String ans="";
        int left;
        int right;
        StringBuilder str  = new StringBuilder(); 
        
        for(int i =0; i+1<s.length(); i++)
        {
            str.setLength(0);
            if(s.charAt(i) == s.charAt(i+1) )
            {
                left = i-1;
                right = i+2;
                str.append(s.charAt(i));
                str.append(s.charAt(i+1));
                while(left >=0 && s.charAt(left) == s.charAt(i))
                {
                    str.insert(0, s.charAt(left));
                    left--;
                }
                while(right <s.length() && s.charAt(right) == s.charAt(i))
                {
                    str.append(s.charAt(right));
                    right++;
                }
                 str = GetPalindrome(left, right,  s, str);
                 
            }
            else if( i-1>=0)
            {
                if(s.charAt(i-1) == s.charAt(i+1))
                {
                    
                    left = i-2;
                    right = i+2;
                    
                    str.append(s.charAt(i-1));
                    str.append(s.charAt(i));
                    str.append(s.charAt(i+1));
                     str = GetPalindrome(left, right,  s, str);
                }
            }
            
           
            ans = ans.length() > str.length() ? ans : str.toString();
            
        }
         
        return (ans.length()==0) ? String.valueOf(s.charAt(0)): ans;
    }
    
    public StringBuilder GetPalindrome(int left, int right, String s, StringBuilder sb)
    {
        
        while( left >=0 && right <s.length() && s.charAt(right) == s.charAt(left))
         {
            sb.append(s.charAt(right));
            sb.insert(0, s.charAt(left));
            left--;
            right++;
         }
                    
       return sb;            
                   
    }
}
