/*
 * We define a harmonious array as an array where the difference between its maximum value and 
 * its minimum value is exactly 1.
 * Given an integer array nums, return the length of its longest harmonious subsequence among all
 * its possible subsequences.
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no 
 * elements without changing the order of the remaining elements.
 * 
 * Example 1:
 * Input: nums = [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * 
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 2
 * 
 * Example 3:
 * Input: nums = [1,1,1,1]
 * Output: 0
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 104
 * -109 <= nums[i] <= 109
 */

class Solution {
    public int findLHS(int[] nums) {
       
        int maxLength =  0;
        int count = 1; 
        Arrays.sort(nums);
        
        int firstNum = nums[0];
        
        Integer second_num_index = null;
        
        for( int i =1; i< nums.length; i++)
        {
            if(second_num_index == null && firstNum != nums[i])
                second_num_index = i;
            
            
            if(  firstNum == nums[i])
               count++;
            else if( Math.abs(firstNum - nums[i]) ==  1 )
            {
                count++;
                maxLength= maxLength > count ? maxLength : count;
            }
            
            if(Math.abs(firstNum - nums[i]) >  1 )
            {
                firstNum = nums[second_num_index];
                i=second_num_index;
                count=1;
                second_num_index = null;
            }
               
        }
       
        return maxLength  ;

    }
}
