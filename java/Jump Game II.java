/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 105

*/

class Solution {
    public int jump(int[] nums) {
        
        int[] steps = new int[nums.length];
        
        for(int i =nums.length - 2; i>=0; i-- )
        {
            steps[i] = findMinStep(steps, i, nums); 
        }
        
        return steps[0];
        
    }
    
    public int findMinStep(int[] steps, int i, int[] nums){
        
        
        int len = nums[i];
        if( len == 0 ) return -1;
        
        int minstep = Integer.MAX_VALUE;
        while( len>=1)
        {
           if(i+len < steps.length && steps[i+len] != -1  )
                minstep = Math.min(minstep,steps[i+len] + 1);
            
            len--;
        }
        
        return minstep == Integer.MAX_VALUE ? -1: minstep;
    }
}
