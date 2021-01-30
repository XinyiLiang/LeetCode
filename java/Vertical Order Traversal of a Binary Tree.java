/* 
 * Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
 * For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) 
 * and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
 * The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting
 * from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. 
 * In such a case, sort these nodes by their values.
 * 
 * Return the vertical order traversal of the binary tree.
 * 
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 * Column -1: Only node 9 is in this column.
 * Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
 * Column 1: Only node 20 is in this column.
 * Column 2: Only node 7 is in this column.
 * 
 * Example 2:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 * Explanation:
 * Column -2: Only node 4 is in this column.
 * Column -1: Only node 2 is in this column.
 * Column 0: Nodes 1, 5, and 6 are in this column.
 *           1 is at the top, so it comes first.
 *           5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
 * Column 1: Only node 3 is in this column.
 * Column 2: Only node 7 is in this column.
 * 
 * Example 3:
 * Input: root = [1,2,3,4,6,5,7]
 * Output: [[4],[2],[1,5,6],[3],[7]]
 *
 * Constraints:
 * The number of nodes in the tree is in the range [1, 1000].
 * 0 <= Node.val <= 1000
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
    
     int lowest = Integer.MAX_VALUE;
     int highest= Integer.MIN_VALUE;
     
     List<Integer> nodevalue = new ArrayList<Integer>();
     List<int[]> index = new ArrayList<int[]>();
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        Traver(root,0,0);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        while(!nodevalue.isEmpty() && lowest <=highest)
        {
            List<Integer> sub = new ArrayList<Integer>();
            List<Integer> sub_y_index = new ArrayList<Integer>();
        
            for( int i = 0; i<index.size();i++)
            {
                if( index.get(i)[0] == lowest)
                {
                     sub.add(nodevalue.get(i));
                     sub_y_index.add(index.get(i)[1]);    
                     nodevalue.remove(i);
                     index.remove(i);
                     i--;
                }
            }
            sub = sortSub(sub, sub_y_index);
            ans.add(sub);
            lowest++;
    
        }
         
        return ans;
    }
    
    public void Traver(TreeNode root, int x, int y)
    {
        if(root==null)
            return;
   
        lowest = x < lowest ? x : lowest;
        highest = x > highest? x: highest;
      
        nodevalue.add(root.val);
        index.add(new int[]{x,y});
    
        Traver(root.left, x-1,y-1);
        Traver(root.right, x+1,y-1);
        
    }
    
    public List<Integer> sortSub( List<Integer> sub , List<Integer> yIndex)
    {
        boolean wellSort = false;
        
        while(!wellSort)
        { 
           
            for(int i = 0; i+1<yIndex.size(); i++)
          {
            if( yIndex.get(i) < yIndex.get(i+1))
            {
                int temp = yIndex.get(i);
                yIndex.set(i, yIndex.get(i+1));
                yIndex.set(i+1, temp);
                
                int temp2 = sub.get(i);
                sub.set(i, sub.get(i+1));
                sub.set(i+1, temp2);
            }
            
          }
            boolean nextstatus = true;
            for(int i = 0; i+1<yIndex.size(); i++)
            {
                if( yIndex.get(i) < yIndex.get(i+1))
                nextstatus = false;
            }
            wellSort = nextstatus;
            
        }
        
        List<Integer> sameYvalue = new ArrayList<Integer>();
        int count = 0;
        int i;
        int current = yIndex.get(0);
        
        for( i = 0; i<yIndex.size(); i++)
          {
            if( yIndex.get(i) ==  current)
            {
              sameYvalue.add(sub.get(i));
              count++;
            }
            else
            {
                current =  yIndex.get(i);
               
                Collections.sort(sameYvalue);
                
                while(!sameYvalue.isEmpty())
               {
                   sub.set(i-count, sameYvalue.get(0));
                   sameYvalue.remove(0);
                   count--;
               }
                i--;
                count = 0;
                
            }
              
          }
        
              Collections.sort(sameYvalue); 
              while(!sameYvalue.isEmpty())
               {
                   sub.set(i-count, sameYvalue.get(0));
                   sameYvalue.remove(0);
                   count--;
               }
      
      return sub;
    }
    

}
