class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int cur = 1;
        int count=0;
        int i=0;
        int arr_value;
        
        while( cur<=2000)
        {
            if( i< arr.length)
            {
                arr_value = arr[i];
            }
            else
                arr_value = arr[arr.length -1];
            
            
                 if(cur != arr_value)
                 {
                    count++;
                
                    if(k == count)
                    return cur;
                  
                 }
                 else
                      i++;
                 
            
           
            cur++;
        }
        
        return cur;
    }
}
