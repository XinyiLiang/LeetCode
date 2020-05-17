/*
 * Given a singly linked list, group all odd nodes together followed by
 * the even nodes. Please note here we are talking about the node number 
 * and not the value in the nodes.

 * You should try to do it in place. The program should run in O(1) space 
 * complexity and O(nodes) time complexity.
 *
 * Example :
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 */
 class MySolution {
    public ListNode oddEvenList(ListNode head) {
  
        ListNode next_node = head;
        
        
        Stack<ListNode> StackOfEven = new Stack<>();
        Stack<ListNode> StackOfOdd = new Stack<>();
        
        
        while(next_node != null){
            ListNode node1 = new ListNode( next_node.val);
            StackOfOdd.push( node1); 
            
            if(next_node.next !=null)
            {
              ListNode node2 = new ListNode( next_node.next.val);
              StackOfEven.push(node2);
              next_node = next_node.next;
            }
            
            next_node = next_node.next==null? null:next_node.next;;
        }
        
        ListNode Final_List = !StackOfEven.isEmpty() ?  StackOfEven.peek() : null;
        if(!StackOfEven.isEmpty())
            StackOfEven.pop() ;

        while( !StackOfEven.isEmpty() ){
            
            ListNode child_Node = StackOfEven.peek();
            child_Node.next = Final_List;
            Final_List= child_Node;
           
            StackOfEven.pop();   
        }
        
        while( !StackOfOdd.isEmpty() ){
            
            ListNode child_Node = StackOfOdd.peek();
            child_Node.next = Final_List;
            Final_List= child_Node;
           
            StackOfOdd.pop();   
        }
       
        return Final_List ;
    }
}

/* Better Solution with less run time */

class BetterSolution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        ListNode c = p.next;
        ListNode idx = head;
        while (p != null && p.next != null) {
            c = p.next; 
            ListNode n = c.next;         
            c.next = idx.next;
            idx.next = c;
            p.next = n;
            idx = idx.next;
            p = p.next;
        }
        return head;
    }
}
