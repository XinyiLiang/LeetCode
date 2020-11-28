class Solution {
    public boolean canPartition(int[] nums) {      
        Arrays.sort(nums);
        int[] nums_2 = nums.clone();
       
        int total = Arrays.stream(nums).sum();
        
        if( total %2 !=0  )
            return false;
        else if (nums[nums.length -1] > total/2)
            return false;
        else if (nums[nums.length -1] == total/2)
            return true;        
        
        for(int i = nums.length -1 ; i>=0 ;i--) // from large to small
        {
            
            for(int j = nums_2.length -1; j>=0 ;j--) // from small to large
            {                
                      if (i!=j && nums[i]+nums_2[j] == total /2)
                          return true;
                       else if (i!=j)
                           nums_2[j] = nums[i]+nums_2[j] < total /2 ? nums[i]+nums_2[j] : nums_2[j];
                           
            }
            
            
        }
      
        return false;
    }
}
