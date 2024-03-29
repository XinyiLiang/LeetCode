/* Reordered Power of 2
 * 
 * Solution
 * Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
 * 
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 * 
 * Example 1:
 * Input: 1
 * Output: true
 * 
 * Example 2:
 * Input: 10
 * Output: false
 * 
 * Example 3:
 * Input: 16
 * Output: true
 * 
 * Example 4:
 * Input: 24
 * Output: false
 * 
 * Example 5:
 * Input: 46
 * Output: true
 * 
 * Note:
 * 1 <= N <= 10^9
*/


class Solution {
    public boolean reorderedPowerOf2(int N) {
        
        int i= 0;
        int x = 2;
        
        
        char[] Nchars = String.valueOf(N).toCharArray();
        Arrays.sort(Nchars);
        
        while( x<= (int)Math.pow(10,9))
        {
            x = (int)Math.pow(2,i);
            i++;
            char[] xchars = String.valueOf(x).toCharArray();
             Arrays.sort(xchars);
            
            if(xchars.length > Nchars.length)
                break;
            
            if(Arrays.equals(Nchars, xchars))
                return true;
        }
        
        return false;
    }
}
