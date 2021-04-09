/* Given a string containing digits from 2-9 inclusive, return all possible letter 
 * combinations that the number could represent. Return the answer in any order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2:
 * Input: digits = ""
 * Output: []
 * 
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * Constraints:
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
*/


class Solution {
    
     List<String> ans = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        
        
        if(digits.length() == 0 ) return ans;
        
        List<char[]> letterlist = new ArrayList<char[]>();
        letterlist.add(new char[]{'a','b','c'});
        letterlist.add(new char[]{'d','e','f'});
        letterlist.add(new char[]{'g','h','i'});
        letterlist.add(new char[]{'j','k','l'});
        letterlist.add(new char[]{'m','n','o'});
        letterlist.add(new char[]{'p','q','r','s'});
        letterlist.add(new char[]{'t','u','v'});
        letterlist.add(new char[]{'w','x','y','z'});
        
        
        char[] digitsArr = digits.toCharArray();
      
        int d = 0; 
        
        StringBuilder sb = new StringBuilder();
        sb = process( letterlist, digitsArr, d, sb );
    
        return ans;
    }
    
    public StringBuilder process(List<char[]> letterlist,char[] digitsArr, int d, StringBuilder sb)
    {
        
        
        for( char c : letterlist.get(Character.getNumericValue(digitsArr[d])-2))
        {
              sb.append(c);
              
              if ( d == digitsArr.length - 1)
              {
                  ans.add(sb.toString());
                  sb.deleteCharAt(d);
              } 
              else
               sb = process (letterlist, digitsArr,d+1, sb);
        }
        
        if(sb.length()>0)
        sb.deleteCharAt(sb.length()-1);
        
        return sb;
        
    }
}
