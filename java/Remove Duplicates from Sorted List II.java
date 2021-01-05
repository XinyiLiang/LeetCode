/* Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * Constraints:
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 * Example 2:
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 * Example 1:
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 *
 */
 
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
 
 /* runtime 0 ms*/
 
class Solution {
    
    int duplicate = 200;
  
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null)
            return head;
        
        if( head.next == null)
        {
            if ( head.val == duplicate)
                return null;
            else
                return head;
        }
        
        ListNode ans = new ListNode();
       
            if ( head.val != head.next.val)
            {
                if ( head.val == duplicate)
                    ans = deleteDuplicates(head.next);
                else
                {
                    ans = head;
                    ans.next = deleteDuplicates(head.next);
                }
              
            }   
            else
            {
              duplicate =  head.val;
              ans = deleteDuplicates(head.next);
            
            }
 
        return ans;
    }
}
