/*   Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
*/



class Solution {
    public boolean checkPossibility(int[] nums) {
       
        int count = 0; 
        int bignumindex = 0;
        int smallnumindex = 0;
        for(int i  = 0; i+1<nums.length; i++)
        {
            if(nums[i]>nums[i+1])
            {
                count++;
                bignumindex = i;
                smallnumindex = i+1;
            }
            if(count>= 2) return false;
        }
        
        if(count ==0 )
            return true;
        else if ( count == 1)
        {
            // turn big num to small num to see if it works
            int bignum = nums[smallnumindex];
            if( ( bignumindex - 1 >=0 && nums[bignumindex-1] <= bignum) ||bignumindex == 0 )
                return true;
            
            //turn small num to bigger num to see if it works
            int smallnum = nums[bignumindex];
            
            if( ( smallnumindex+1<nums.length && nums[smallnumindex+1] >= smallnum) ||smallnumindex == nums.length -1 )
                return true;    
            
        }
        
            return false;
        
        
    }
}
