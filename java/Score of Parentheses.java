/* Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * 
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * Example 1:
 * Input: "()"
 * Output: 1
 * 
 * Example 2:
 * Input: "(())"
 * Output: 2
 * 
 * Example 3:
 * Input: "()()"
 * Output: 2
 * 
 * Example 4:
 * Input: "(()(()))"
 * Output: 6
 *
 * Note:
 *
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
*/


class Solution {
    public int scoreOfParentheses(String S) {
        
        StringBuilder sb = new StringBuilder(S);
        
        for(int i=0; i+1<sb.length(); i++)
        {
            if(sb.charAt(i)==')' && sb.charAt(i+1)=='(' )
            {
                sb.insert(i+1,'+');
                i++;
            }
        }
        
        int open = sb.lastIndexOf("(");
        int close = sb.indexOf(")",open);
        
        while(open != -1)
        {
            if(open+1 == close)
            {
                sb.setCharAt(open,'1');
                sb.deleteCharAt(close);
            }
            else
            {
                int num1 = 0; 
                int num2 = 0;
                int total=0;
                boolean nextNum = false;
                for(int k=open+1; k<close; k++)
                {
                    
                    if(Character.isDigit(sb.charAt(k)) && nextNum == false)
                        num1 = num1*10 + Character.getNumericValue(sb.charAt(k));
                    else if(Character.isDigit(sb.charAt(k)) && nextNum)
                        num2 = num2*10 + Character.getNumericValue(sb.charAt(k)); 
                    else if (sb.charAt(k) == '+')
                    {
                        total = num1+num2;
                        num1 = total;
                        num2=0;
                        nextNum = true; 
                    }
                }
                total = num1+num2;
                String replaceStr = String.valueOf(total*2);
                sb.replace(open, close+1, replaceStr);
            }
          
            
            
            open = sb.lastIndexOf("(");
            close = sb.indexOf(")",open);
        }
        
       
                int num1 = 0; 
                int num2 = 0;
                int total=0;
                boolean nextNum = false;
        
            for(int i=0; i<sb.length() && sb.indexOf("+")!=-1; i++)
                {
                    
                    if(Character.isDigit(sb.charAt(i)) && nextNum == false)
                        num1 = num1*10 + Character.getNumericValue(sb.charAt(i));
                    else if(Character.isDigit(sb.charAt(i)) && nextNum)
                        num2 = num2*10 + Character.getNumericValue(sb.charAt(i)); 
                    else if (sb.charAt(i) == '+' || i==sb.length()-1 )
                    {
                        total = num1+num2;
                        num1 = total;
                        num2=0;
                        nextNum = true; 
                    }
                
                if(i== sb.length()-1)
                   {
                    total = num1+num2;
                    String replaceStr = String.valueOf(total);
                    sb.replace(0, sb.length(), replaceStr);
                   }
                }
                
        
        
        return Integer.parseInt(sb.toString());
       
    }
}
