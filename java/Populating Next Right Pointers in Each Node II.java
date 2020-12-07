/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       
       List<Node> parent = new ArrayList<Node>();
        List<Node> children = new ArrayList<Node>();
        
        if (root == null)
            return null;
        else
        {
            parent.add(root);
        } 
         
        int i;
        
           for( i=0; i<parent.size(); i++)
                {
                   
                 if (i==parent.size()-1)
                    {
                      
                        parent.get(i).next = null;
                        
                        if(parent.get(i).left!=null)
                            children.add(parent.get(i).left);
                     
                        if(parent.get(i).right!=null)
                            children.add(parent.get(i).right);
                       
                        parent.clear();
                        parent.addAll(children);
                        children.clear();
                        i=-1;
                     
                    }
                    else
                    {  
                       
                     parent.get(i).next = parent.get(i+1);
                        
                        if(parent.get(i).left!=null)
                            children.add(parent.get(i).left);
                        if(parent.get(i).right!=null)
                            children.add(parent.get(i).right);
                    }
         
                }
    
        
        return root;
    }
    
}
