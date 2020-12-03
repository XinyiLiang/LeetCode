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
    public TreeNode increasingBST(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        
        list.add(root.val);
        listNode.add(root);
        int i = 0;
       
        while(i < listNode.size() )
        {
            root = listNode.get(i);
            
            if (root.right != null)
            {
                list.add(root.right.val);
                listNode.add(root.right);
            }
            if (root.left != null)
            {
                list.add(root.left.val);
                listNode.add(root.left);
            }
            
            i++;
        }
        Collections.sort(list);
        TreeNode new_root = new TreeNode(list.get(0));
        TreeNode node = new_root;
        
        for ( i=1; i< list.size(); i++)
        {
            node.left= null;
            node.right = new TreeNode(list.get(i));
            node = node.right;
        }
        return new_root ;
    }
}
