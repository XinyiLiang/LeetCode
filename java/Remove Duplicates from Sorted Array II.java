class Solution {
    public int removeDuplicates(int[] nums) {
        
        if ( nums.length <=2 )
            return nums.length;
 
        int frontNum=nums[0];
        int count=1;
        int length=1;
       
        
        int j ;
        for(int i =1; i< nums.length; i++)
        {
            if ( frontNum > nums[i]) //reach the end of original number
                break;
             
            if( frontNum == nums[i] && count != 2)
            { 
                count++;
                length++;
            }
            else if( frontNum != nums[i] && count == 2)
            { 
                count=1;
                frontNum = nums[i];
                length++;
            }
            else  if( frontNum != nums[i] && count < 2)
            { 
                count=1;
                length++;
                frontNum = nums[i];
            }
            else if( frontNum == nums[i] && count == 2)
            { 
               
                 for (  j = i+1; j< nums.length; j++)
                  {
                    nums[j-1] = nums[j];
                  }
               
                nums[nums.length-1]= Integer.MIN_VALUE;
                
                i--;
            }
            
            
            
        }
       
        nums= Arrays.copyOf(nums, length);
        
        return length;
        
    }
}
