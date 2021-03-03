/* You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, 
 * due to some error, one of the numbers in s got duplicated to another number in the set, which results 
 * in repetition of one number and loss of another number.
 * 
 * You are given an integer array nums representing the data status of this set after the error.
 * 
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * 
 * Example 1:
 *
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * 
 * Example 2:
 * 
 * Input: nums = [1,1]
 * Output: [1,2]
 * 
 * Constraints:
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */

class Solution {
    public int[] findErrorNums(int[] nums) {
        
        Arrays.sort(nums);

        int[] ans = new int[2];
        int current = 1;
        Integer missing =  null;
        
        for(int i=0; i+1<nums.length; i++)
         {
            if(ans[0]!=0 && ans[1]!=0 )
                break;
            
            if(missing != null && missing == nums[i])
                missing = null;
            
            if(missing == null && current != nums[i])
                missing = current;
            
             if(nums[i]==nums[i+1])
                 ans[0]=nums[i];
            
            current++;
         }
        
        if(missing != null && missing == nums[nums.length-1])
                missing = null;
            
            if(current != nums[nums.length-1])
                missing = current;
        
        
        ans[1]=missing;
        return ans;
    }
}
