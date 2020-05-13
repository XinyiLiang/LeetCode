/* Q: You are given a sorted array consisting of only integers where every 
 * element appears exactly twice, except for one element which appears exactly once. 
 * Find this single element that appears only once.
 *
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * 
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 */

class Solution {
    public int singleNonDuplicate(int[] nums) {
     int j=0;
     
     if (nums.length == 1)
            return nums[0];

        while ( j != nums.length -1)
        {
            if (nums[j]!=nums[j+1])
                return nums[j];
            
            j=j+2;   
        }
        
        if (nums.length%2 !=0 && j == nums.length-1)
            return nums[j];
            
        return -1;
    }
}
