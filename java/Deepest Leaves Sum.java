/* Given the root of a binary tree, return the sum of values of its deepest leaves.
 * 
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * 
 * Example 2:
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */
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
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> deepestnodes = new ArrayList<TreeNode>();
        int sum = 0; 
        
        deepestnodes.add(root);
        
        deepestnodes = GetToDeepest(deepestnodes);
        
        for( int i = 0; i<deepestnodes.size(); i++)
        {
            sum += deepestnodes.get(i).val;
        }
        return sum;
    }
    
    public List<TreeNode> GetToDeepest(List<TreeNode> nodelist)
    {
        List<TreeNode> NextLevelnodes = new ArrayList<TreeNode>();
        
         for( int i = 0; i<nodelist.size(); i++)
         {
             TreeNode n = nodelist.get(i);
             if( n.left != null)
                 NextLevelnodes.add(n.left);
             if( n.right != null)
                 NextLevelnodes.add(n.right);
         }
        
        if( NextLevelnodes.isEmpty())
            return nodelist;
        else
            return GetToDeepest(NextLevelnodes);
        
    }
}
