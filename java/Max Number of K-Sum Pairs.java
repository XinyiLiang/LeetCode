/* You are given an integer array nums and an integer k.
 * In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
 * Return the maximum number of operations you can perform on the array.
 *
 *
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 *
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 *
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 *
 */
 
class Solution {
    public int maxOperations(int[] nums, int k) {
        
        
        int count=0;
       
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
       
        for(int i=0; i<nums.length; i++)
        {
           hm.put(nums[i],hm.getOrDefault(nums[i], 0)+1);
        }
        
         Iterator iterator = hm.entrySet().iterator();
         while(iterator.hasNext()) 
         {
        
             Map.Entry mentry = (Map.Entry)iterator.next();
             
             if(hm.containsKey(  k-(int)mentry.getKey()    ))
                  count+=Math.min(	(int)mentry.getValue(), hm.get(  k-(int)mentry.getKey() )  );
                  
          }
        return count/2;
    }
    
   
    
}
