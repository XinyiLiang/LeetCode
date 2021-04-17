/* You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent 
   and equal letters from s and removing them, causing the left and the right side of the deleted 
   substring to concatenate together.

   We repeatedly make k duplicate removals on s until we no longer can.

   Return the final string after all such duplicate removals have been made. 
   It is guaranteed that the answer is unique.
   
   Example 1:
   Input: s = "abcd", k = 2
   Output: "abcd"
   Explanation: There's nothing to delete.
   
   Example 2:
   Input: s = "deeedbbcccbdaa", k = 3
   Output: "aa"
   Explanation: 
   First delete "eee" and "ccc", get "ddbbbdaa"
   Then delete "bbb", get "dddaa"
   Finally delete "ddd", get "aa"
   
   Example 3:
   Input: s = "pbbcggttciiippooaais", k = 2
   Output: "ps"
   
   Constraints:
   1 <= s.length <= 105
   2 <= k <= 104
   s only contains lower case English letters.
*/




class Solution {
    
      Stack<Character> stack = new Stack<Character>();
      Stack<Integer> count = new Stack<Integer>();
        
    public String removeDuplicates(String s, int k) {
        
        char[] chars = s.toCharArray();
     
        
        for(int i=0; i< chars.length; i++)
        {
            if( stack.isEmpty())
            {
                stack.push(chars[i]);
                count.push(1);
                continue;
            }
            
            if( stack.peek() == chars[i])
            {
                count.push( count.peek()+1);
            }
            else
                count.push(1);
            
            stack.push(chars[i]);
     
            if( count.peek() == k)
            {
                removeK( stack, count, k);
            }
            
           
        }
        
        String ans = "";
        while( !stack.isEmpty())
        {
            ans = stack.pop() + ans ;
        }
        return ans;
        
        
    }
    
    public void removeK(Stack<Character> stack,  Stack<Integer> count, int k){
        while( k>0)
        {
            stack.pop();
            count.pop();
            k--;
        }
        
    }
}
