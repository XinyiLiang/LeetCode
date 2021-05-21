/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
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


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root== null) return ans;
        
        List<TreeNode> nodes  = new ArrayList<TreeNode>();
        nodes.add(root);
        int size = nodes.size();
        
        while( size != 0)
        {
            List<Integer> current = new ArrayList<Integer>();
            
            while(size >0)
            {
                TreeNode n = nodes.get(0);
                nodes.remove(0);
                current.add(n.val);
                size--;
                
                if( n.left != null) nodes.add(n.left);
                if( n.right != null) nodes.add(n.right);
            }
            
             ans.add(current);
             size = nodes.size();
        }
        
           
       return ans;
        
    }
}
