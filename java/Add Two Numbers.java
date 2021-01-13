/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
     int carry; 
     
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
            int sum = (l1.val + l2.val + carry) >=10 ? (l1.val + l2.val + carry)%10 : (l1.val + l2.val + carry);
            
            carry = (l1.val + l2.val+ + carry) >=10 ? 1 : 0;
            
            ListNode newNode = new ListNode(sum);
            
            if(l1.next == null && l2.next == null)
            {
                if (carry != 0)
                    newNode.next = new ListNode(carry);               
                 return newNode;
            }
        
        
            if( l1.next != null && l2.next != null)
                 newNode.next = addTwoNumbers(l1.next,l2.next);
          
            if(l2.next == null && l1.next != null)
               newNode.next = addTwoNumbers(l1.next, new ListNode(0));
            else if(l1.next == null && l2.next !=null)
                newNode.next = addTwoNumbers(new ListNode(0),l2.next);
      
            return  newNode;
       
    }
}
