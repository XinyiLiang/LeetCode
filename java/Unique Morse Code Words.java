class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] MorseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
       
        HashSet<String> decode = new HashSet<String>();
        String decodeStr="";
        
        for (int i =0 ; i< words.length; i++)
        {
            
            for( int j=0; j<words[i].length(); j++)                 
                 decodeStr += MorseCode[words[i].charAt(j)-'a'];
           
            decode.add(decodeStr);
            
            decodeStr="";
        }
        
        
        return decode.size();
    }
}
