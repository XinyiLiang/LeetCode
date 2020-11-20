class Solution {
    public boolean search(int[] nums, int target) {
       
        if(nums.length ==0)
            return false;
        
       Arrays.sort(nums);
        
        if (nums[0] == target)
        return true;
          
        boolean found=false;
        
        int length = nums.length;
        int min = 0;
        
        
            while(length -min > 1 && length>=0 && min>=0)
        {
           if (target ==nums[(int)Math.floor((length-min)/2+min)])
           {    found = true;
                break;
           }
           
               
            if (target < nums[(int)Math.floor((length-min)/2+min)])
                  length = length - (int)Math.floor((length-min)/2);
            else
             min = (int)Math.floor((length-min)/2)+min;
             
           
               
        }
        
        return found;
    }
}
