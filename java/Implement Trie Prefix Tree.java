/* LeetCode Challenge
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");   
 * trie.search("app");     // returns true
 * 
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
*/

class Node {
    char value;
    Node[] children;
    boolean isEnd;
    
    public Node(char value){
        this.value = value;
        this.children = new Node[26];
        this.isEnd = false;
    }
    
    public Node(){
        this.children = new Node[26];
        this.isEnd = false;
    }
    
}




class Trie {
    Node root;
    /** Initialize your data structure here. */ 
    public Trie() {
      this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node pointerNode = root;
        int i ;
        for (i= 0 ; i< word.length(); i++){
            if (pointerNode.children[word.charAt(i) - 'a'] == null)
                pointerNode.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
            pointerNode = pointerNode.children[word.charAt(i) - 'a'];
            
        }
        pointerNode.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node pointerNode = root;
        int i;
        for (i=0; i< word.length(); i++){
            if (pointerNode.children[word.charAt(i) - 'a']==null)
            return false;
            pointerNode = pointerNode.children[word.charAt(i) - 'a'];
        }
        return pointerNode.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       Node pointerNode = root;
       int i;
        for (i=0; i< prefix.length(); i++){
            if (pointerNode.children[prefix.charAt(i)-'a']==null)
            return false;
            pointerNode = pointerNode.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */Implement Trie (Prefix Tree)
