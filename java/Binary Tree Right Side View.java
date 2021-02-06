/* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \ 
 * 2     3         <---
 *  \     \
 *   5     4       <---
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
    
    List<Integer> ans= new ArrayList<Integer>();
   
    List<TreeNode> NextLayerNodes = new ArrayList<TreeNode>();
    
    public List<Integer> rightSideView(TreeNode root) {
      
       if(root!=null)
           ans.add(root.val);
       else 
           return ans;
        
        if(root.left!=null)
        NextLayerNodes.add(root.left);
        
        if(root.right!= null)
        NextLayerNodes.add(root.right);
       
        while(!NextLayerNodes.isEmpty())
        GetNextLayerNodes(NextLayerNodes);
       
        return ans;
    }
    
    private void GetNextLayerNodes(List<TreeNode> NextLayerNodes) {
        
        int size = NextLayerNodes.size();
        
        if(size>0)
        {
            ans.add(NextLayerNodes.get(size-1).val);
        }
        
        for(int i =0; i<size; i++)
        {
            if(NextLayerNodes.get(i).left!=null)
            NextLayerNodes.add(NextLayerNodes.get(i).left);
        
            if(NextLayerNodes.get(i).right!= null)
            NextLayerNodes.add(NextLayerNodes.get(i).right);
        }
        
        while(size>0)
        {
            NextLayerNodes.remove(size-1);
            size--;
        }
        
    }
}
