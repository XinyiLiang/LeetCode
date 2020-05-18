/* Leetcode challenge
 * Find All Anagrams in a String
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */
 
 // my solution
 class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
       List<Integer> list = new ArrayList<Integer>();
       HashMap<Character, Integer> Sub_s_map = new HashMap<>(); 
       HashMap<Character, Integer> p_map = new HashMap<>(); 
       
        if (s.length() == 0 || (p.length() > s.length()))
            return list;
       
       for(int i = 0; i<p.length(); i++){
            p_map.put(p.charAt(i), p_map.getOrDefault(p.charAt(i), 0) + 1); 
            Sub_s_map.put(s.charAt(i),Sub_s_map.getOrDefault(s.charAt(i), 0) + 1); 
       }
       
          int i=0;  
           if(p_map.equals(Sub_s_map))
           list.add(i);
           
        while( i+p.length()<s.length())
        {
        Sub_s_map.put(s.charAt(i),Sub_s_map.getOrDefault(s.charAt(i), 0) - 1); 
            
        if ( Sub_s_map.get(s.charAt(i)) == 0 )
            Sub_s_map.remove(s.charAt(i)); 
        
        Sub_s_map.put(s.charAt(i+p.length()),Sub_s_map.getOrDefault(s.charAt(i+p.length()), 0) + 1); 
       
           if(p_map.equals(Sub_s_map))
           list.add(i+1);
        i++;    
        }
        
        return  list;   
    }
}

// better solution, all test cases runtime total 7ms
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
