/* Valid Parentheses
 *
 * iven a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Example 1:
 * Input: s = "()"
 * Output: true
 * 
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 */
 
 class Solution {
    public boolean isValid(String s) {
        //'(', ')', '{', '}', '[' and ']',
        
        StringBuilder sb= new StringBuilder(s);
        
        int first = sb.lastIndexOf('('+"");
        int second = sb.indexOf(')'+"", first);
        
        while(first!= -1 &&  second !=-1 && first<second)            
        {
            if( first+1==second || isValid( sb.substring(first+1, second)))
            {
                 sb.delete(first,second+1);
            }
            else
                return false;
           
             first = sb.lastIndexOf('('+"");
             second = sb.indexOf(')'+"", first);
        }
       
        int x1 = sb.lastIndexOf('['+"");
        int x2= sb.indexOf(']'+"", x1);
       
        while(x1!= -1 &&  x2 !=-1 && x1<x2)            
        {
            
            if( x1+1==x2 || isValid( sb.substring(x1+1, x2)))
            {
                 sb.delete(x1,x2+1);
            } 
            else
                return false;
           
              x1 = sb.lastIndexOf('['+"");
              x2= sb.indexOf(']'+"", x1);
        }
        
        int y1 = sb.lastIndexOf('{'+"");
        int y2= sb.indexOf('}'+"", y1);
        while(y1!= -1 &&  y2 !=-1 && y1<y2)            
        {
            
            if( y1+1==y2 || isValid( sb.substring(y1+1, y2)))
            {
                 sb.delete(y1,y2+1);
            } 
            else
                return false;
        
             y1 = sb.lastIndexOf('{'+"");
             y2= sb.indexOf('}'+"", y1);
        }
        
        
        return sb.length() == 0? true: false;
    }
    
}
