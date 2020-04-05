//2020-04-05

class Solution {
public:
    int singleNumber(vector<int>& nums) {         
        int  count, uniqueNumber=0;
     
     for (int i = 0; i < nums.size(); i++ )
        { count = 0;
         for (int j = 0; j < nums.size(); j++ )
         {
             if ( nums[i] == nums[j] )
                count++;            
             }
         if ( count == 1 )
         {
            uniqueNumber=nums[i];
            break;
         }       
        }    
    return uniqueNumber;
    }
};
