class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        int total = 0;
        int[] arr = new int[60];
        for( int i =0; i< time.length ; i++)
        {            
                   arr[time[i]%60]++;
        }
        count = arr[0];
        while(count>=1)
        {
            total += (count-1);
            count--;
        }
        count = arr[30];
        while(count>=1)
        {
            total += (count-1);
            count--;
        }
        
        for ( int i =1; i<30; i++)
        {
                total += arr[i]*(arr[60-i]);
        }
        
        
        return total;
        
    }
}
