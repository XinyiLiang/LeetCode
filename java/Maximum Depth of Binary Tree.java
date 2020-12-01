

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
 *
 * 0ms solution:
 * class Solution {
 *   public int maxDepth(TreeNode root) {
 *       if(root==null)
 *           return 0;
 *       else
 *       {
 *           return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
 *       }
 *   }
 * }
 */
class Solution {
    
    
    public int maxDepth(TreeNode root) {
       
        
   List<TreeNode> nodeList = new ArrayList<TreeNode>();
        
        if (root == null)
            return 0;
        else if(root.right ==null &&root.left ==null)
            return 1;
        else
           nodeList.add(root);
 
        
        int depth=0;
        int i =0;
        
        int start =0; 
        int end = nodeList.size();
        
        boolean ThisNodeHasChild=false;
        
        while(i<nodeList.size())
        {
            
                  while(i<end )
                    {
                      
            
                         if (nodeList.get(i).right != null )
                           { 
                             nodeList.add(nodeList.get(i).right);
                             ThisNodeHasChild = true;
                             
                            }
            
                         if (nodeList.get(i).left != null )
                           { 
                            nodeList.add(nodeList.get(i).left);
                            ThisNodeHasChild = true;
                             
                           }
            
         
            
                        i++;
                     }
           end = nodeList.size();
            
            System.out.println(nodeList.get(i-1).val);
           if (ThisNodeHasChild)
                depth++;
        
        
        }
        
        
        return depth;
    }
    
    
}
