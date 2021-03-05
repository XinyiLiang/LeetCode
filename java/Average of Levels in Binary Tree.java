/* Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 *  Example 1:
 *  Input:
 *        3
 *       / \
 *      9   20
 *      /    \
 *     15     7
 *  Output: [3, 14.5, 11]
 *  Explanation:
 *  The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 *  
 *  Note:
 *  The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        
         List<Double> ans = new ArrayList<Double>();
        
         if (root == null)  return ans;
        
         Queue<TreeNode> q = new LinkedList<TreeNode>(); 
         q.add(root);
         int size = q.size();
         
         while(!q.isEmpty())
         {
             long total= 0;
             int NodesNum = size;
             
             while(size>0)
             {   
                 TreeNode n = q.poll();
                 size--;
                 if(n.left != null)
                     q.add(n.left);
             
                  if(n.right != null)
                       q.add(n.right);
             
                  total += n.val;
             }   
             
             double avg = total/(double)NodesNum;
             ans.add(avg);
             size = q.size();
          }
        
         
        return ans;
    }
}
