/* You are given an integer n. An array nums of length n + 1 is generated in the following way:
 * nums[0] = 0
 * nums[1] = 1
 * nums[2 * i] = nums[i] when 2 <= 2 * i <= n
 * nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
 * Return the maximum integer in the array nums​​​.
 *
 * Constraints: 0 <= n <= 100
 */
 
class Solution {
    public int getMaximumGenerated(int n) {
        
        
        int[] nums = new int[n+1];
        int max=0;
        
        for(int i =0; i<=n; i++)
        {
            if( i <=1 )
               nums[i]=i;
            else if(i%2 == 0 )  
            {
                nums[i] = nums[i/2];
            }
            else if ( i%2 == 1 )
            {
                nums[i] = nums[(i-1)/2] + nums[(i-1)/2+1];
            }
            
            max = max> nums[i]? max : nums[i];
        }
        return max;
        
        
    }
}
