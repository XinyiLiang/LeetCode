/*
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

 * Note: Do not use any built-in library function such as sqrt.

 * Example 1:

 * Input: 16
 * Output: true
 
 * Example 2:

 * Input: 14
 * Output: false
*/


class Solution {
    public boolean isPerfectSquare(int num) {    
      
        int DigitsNum = String.valueOf(num).length();
        
        int maxi;
        int mini;
        int foot;
        
        maxi= (int)(Math.pow(10,Math.floor(DigitsNum/2)+1));

        mini = (int)(Math.pow(10,Math.floor(DigitsNum/2)-1));
 
          while (  Math.abs(maxi-mini)!=1 )
       {  
              foot = mini + (int)Math.floor((maxi - mini)/2);
              
              if ((long)foot*foot==(long)num)
                  return true;
              
              if((long)foot*foot>(long)num)
                  maxi = foot;
             
              if((long)foot*foot<(long)num)
                  mini = foot;      
          }       
     
        return false;    
  }
}
