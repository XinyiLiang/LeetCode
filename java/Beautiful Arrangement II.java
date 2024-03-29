/* Given two integers n and k, you need to construct a list which contains n 
 * different positive integers ranging from 1 to n and obeys the following requirement:
 * 
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * 
 * If there are multiple answers, print any of them.
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * 
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
 * 
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * 
 * Note:
 * The n and k are in the range 1 <= k < n <= 104.
*/



class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(ans[0]);
        
        int reverse = 1; 
        
        for( int i = 1; i< n; i++)
        {
            if( k >0)
            {
            int newNum = ans[i-1] + k* reverse;
            if( list.indexOf( newNum) == -1 && newNum <= n && newNum >0)
            {
                ans[i] = newNum;
                reverse = reverse * (-1);
            }
            else {
                newNum = ans[i-1] + k;
                
                if ( list.indexOf( newNum) == -1 && newNum <= n && newNum >0)
                {
                    ans[i] = newNum;
                }
            }
            
            k--;
            }
            else{
                ans[i] = i+1;
            }
        }
        
       return ans;
        
    }
}
