/* 
 * Next Permutation
 * 
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 *
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * 
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * 
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * 
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 * 
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */


class Solution {
    public void nextPermutation(int[] nums) {
        
        PriorityQueue<Integer> qnums = new PriorityQueue<>();
        int len = nums.length;
        int i;
        int temp = 0;
        int biggerNum=0;
        
        for( i = len -1 ; i>=1; i-- )
        {
            if( nums[i-1] < nums[i] )
            {
                
                temp = nums[i-1];
                biggerNum = nums[i];
                
                int index = i+1;
                while( index <len)
                {
                    if( nums[index]<biggerNum && temp<nums[index])
                    {
                        qnums.add( biggerNum );
                        biggerNum = nums[index];
                    }
                    else
                        qnums.add(nums[index]);
                    
                    index++;
                }
                break;
            }
        }
       
       
        if(qnums.isEmpty() && temp ==0 && biggerNum == 0)
            Arrays.sort(nums);
        else
        {
            nums[i-1] = biggerNum;
            qnums.add(temp);
            
            int j = i;
            
            while(!qnums.isEmpty())
            {
                 nums[j] = qnums.poll();
                 j++;
            }           
           
        }
            
    }
}
