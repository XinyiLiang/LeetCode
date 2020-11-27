class Solution {
    public int longestSubstring(String s, int k) {
        int longest = 0;
        
        
        
        if (s.length() ==0 || s==null || s.length()<k)
            return 0;
        
        if (k==1)
            return s.length();
        
        
        int[] Char_count = new int[26];
        
        for (int i =0 ; i< s.length(); i++)
        {
            Char_count[ s.charAt(i)-'a']++;
        }
       
        boolean flag=false;
        
        String underK ="";
        
        for(int i =0; i<26; i++)
        {
            if (Char_count[i]>=k)
                flag = true;
            
            if ( Char_count[i]>0 && Char_count[i]<k )
            {  
                underK = underK + (char)(i+'a') + "|"; 
            }               
        }
        
        if (underK =="")
             return s.length();
        
       
        if (flag == false)
            return 0;
        
        underK = underK.substring(0,underK.length()-1);
        
        System.out.println("underK="+underK);
        
        String[] arrOfStr = s.split(underK); 
        
        
        
        for(int i =0; i< arrOfStr.length; i++)
        {
            if (arrOfStr[i].length() >=k )
                 longest =  longest >longestSubstring(arrOfStr[i],  k)? longest : longestSubstring(arrOfStr[i],  k);
        }
        
        
    return  longest;    
    }
             
}
