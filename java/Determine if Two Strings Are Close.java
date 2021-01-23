/* Two strings are considered close if you can attain one from the other using the following operations:
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 * Example 1:
 * Input: word1 = "abc", word2 = "bca"
 * Output: true
 * Explanation: You can attain word2 from word1 in 2 operations.
 * Apply Operation 1: "abc" -> "acb"
 * Apply Operation 1: "acb" -> "bca"
 *
 * Example 2:
 * Input: word1 = "a", word2 = "aa"
 * Output: false
 * Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
 *
 * Constraints:
 * 1 <= word1.length, word2.length <= 105
 * word1 and word2 contain only lowercase English letters.
 */






class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if( word1.length() != word2.length())
            return false;
        
        HashMap<Character, Integer> hm1= new HashMap<Character, Integer>(); 
        HashMap<Character, Integer> hm2= new HashMap<Character, Integer>(); 
        
        for( int i=0; i< word1.length(); i++)
        {
            hm1.put(word1.charAt(i), hm1.getOrDefault(word1.charAt(i),0)+1);
            hm2.put(word2.charAt(i), hm2.getOrDefault(word2.charAt(i),0)+1);
        }
        
        int[] count1 = new int[hm1.size()];
        char[] chars1 = new char[hm1.size()];
        int i =0;    
        for (Map.Entry me1 : hm1.entrySet()) {
            count1[i] = (int)me1.getValue();
            chars1[i] = (char)me1.getKey();
            i++;
        }
        
        int[] count2 = new int[hm2.size()];
        char[] chars2 = new char[hm2.size()];
        i =0;    
        for (Map.Entry me2 : hm2.entrySet()) {
            count2[i] = (int)me2.getValue();
            chars2[i] = (char)me2.getKey();
            i++;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return  Arrays.equals(count1, count2) &&  Arrays.equals(chars1, chars2);
    }
}
