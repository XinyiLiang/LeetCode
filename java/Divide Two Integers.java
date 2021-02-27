/* Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * 
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * 
 * Note:
 * 
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. 
 * For this problem, assume that your function returns 231 − 1 when the division result overflows.
 * 
 * Example 1:
 * 
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * 
 * Example 2:
 * 
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
*/






class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend == 0)
            return 0;
        
        
        boolean Negative = false;
        
        if( (divisor<0 && dividend>0) || (divisor>0 && dividend<0) )
            Negative = true;
        
        long count =0;
        long quotien = 0;
        long LDivisor = Math.abs((long)divisor);
        long LDividend = Math.abs((long)dividend); 
        
        while(count<=LDividend )
        {
           
            if(count + count > count + LDivisor &&  count + count <=LDividend )
            {
                 count += count;
                 quotien +=quotien;
            }
            else if( count + LDivisor <= LDividend )
            {
                count += LDivisor ;
                 quotien++;
            }
            else
                break;
               
        }
        long rightLitmit = (long)Math.pow(2,31)-1;
        long leftLitmit = 0-(long)Math.pow(2,31);
        
        if (Negative == true)
            quotien = 0-quotien;
           
        
         if (quotien >  rightLitmit || quotien < leftLitmit ) 
               quotien  = (long)Math.pow(2,31) -1 ;
        
        return (int)quotien;
        
        
    }
}
