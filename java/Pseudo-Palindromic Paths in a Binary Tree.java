/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count=0;
    HashMap<Integer, Integer> NodeCount = new HashMap<>(); 

    public int pseudoPalindromicPaths (TreeNode root) {
      
        Read(root);
        
        return count;
    }
    
    public void Read(TreeNode node)
    {
        if(node == null)
            return;
        
        
        NodeCount.put(node.val, NodeCount.getOrDefault(node.val,0)+1);
        
        if(node.left == null && node.right ==null)
        {
            int OddfrequencyNum=0;
            Iterator hmIterator = NodeCount.entrySet().iterator(); 
            
            while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
              
                if( (int)(mapElement.getValue())%2 ==1 )// this number has odd frequency
                     OddfrequencyNum++;
            
            }
            
            // it is a valid pseudo-palindromic
            if(OddfrequencyNum <=1)
                count++;
             
        } 
        
       
            
        Read(node.left);
            
        Read(node.right);
       
        NodeCount.put(node.val, NodeCount.get(node.val)-1);
    }
}
