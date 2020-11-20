class Solution {
    
    public String decodeString(String s) {
        
        int loopnum=0;
        int Count=0;
        
        String Str = s;
    
        int sub_startIndex =0;
        int sub_endIndex = 0;
        int i=0;
        
        
            while(Str.contains("[")) 
            {
                i=0;
                Count=0;
                sub_startIndex = Str.lastIndexOf('[')+1;
                
                while(Str.lastIndexOf('[') -1 - i>=0)
                {
                    if(Character.isDigit(Str.charAt(Str.lastIndexOf('[') -1 - i)) )
                    { Count++;  System.out.println("Count: "+Count);}
                    else
                        break;
                    i++;
                    
                    
                }
                
                   
                    loopnum = Integer.parseInt(Str.substring(sub_startIndex-Count-1,Str.lastIndexOf('['))); 
                
                    sub_endIndex = Str.indexOf(']', sub_startIndex);
           
                     Str = decode(Str, loopnum, sub_startIndex, sub_endIndex);
                     
    
              
             }   
      
    
        
    return Str;
    
    }
    
    public String decode(String Str, int loopnum,int sub_startIndex, int sub_endIndex)
    {
        
        String newStr=Str.substring(sub_startIndex, sub_endIndex);
        String target = Str.substring(sub_startIndex-1-Integer.toString(loopnum).length(), sub_endIndex+1);
        
    
        for(int i =1; i<loopnum; i++)
        {
            
            newStr +=Str.substring(sub_startIndex, sub_endIndex);
            
        }
       
        String decode = Str.replace(target,newStr);
        
       
        return decode;
    }
    
}
