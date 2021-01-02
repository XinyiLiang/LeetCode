/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
     
    TreeNode Find_node;
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
       
        
        FindNext(cloned, target);
        
        final TreeNode finalnode = Find_node;
        
        return finalnode;
        
    }
    
    
    public void FindNext(TreeNode cloned, TreeNode target)
    {
       if(cloned == null)
           return;
        
        if (cloned.val == target.val)
        {
            Find_node = cloned;
            return;
        }
        else
        {
            FindNext(cloned.right, target);
            FindNext(cloned.left, target);
        }
        
        
    }
}
