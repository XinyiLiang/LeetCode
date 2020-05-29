/* LeetCode challenge: Counting Bits
 * Given a non negative integer number num. 
 * For every numbers i in the range 0 ≤ i ≤ num calculate the number 
 * of 1's in their binary representation and return them as an array.
 */
 
 //using dynamic programming
 //Dynamic programming is all about reusing already calculated values to calculate new ones. 
 
 
 class Solution {
    public int[] countBits(int num) {
        int i = 0, b = 1;
        int[] dp = new int[num+1];
        
        if (num ==0)
        {
            dp[0]=num;
            return dp;
        }
        dp[0]=0;
        while(b<=num)
        {
            while(i<b && i+b<=num)
            {
                dp[i+b] = dp[i]+1;
                i++;
            }
            i=0; b = b<<1;
        }
        
        return dp;
    }
}
