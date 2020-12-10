class Solution {
    public boolean validMountainArray(int[] arr) {
       
        if(arr.length <3)
            return false;
        
        int max =arr[0];
        boolean increased = false;
        boolean decreased = false;
        int i = 1;
        
       while( i < arr.length && max < arr[i]) //increasing
        {
            max = arr[i];
            increased = true;
            i++;
        }
        
        while( i < arr.length && increased && max > arr[i])
        {
            max = arr[i];
            decreased= true;
            i++;
        }
     
        
        return i==arr.length && decreased && increased ? true : false;
    }
}
