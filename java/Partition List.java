/* Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 * 
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 *
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
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
class Solution {
    public ListNode partition(ListNode head, int x) {
       Stack<ListNode> lessthan= new Stack<ListNode>();
       Stack<ListNode> morethan= new Stack<ListNode>();

        while( head != null)
        {
            if ( head.val < x)
                lessthan.push( head);
            else
                morethan.push( head);
            
            head = head.next;
        }
        
        ListNode ans = null; 
        ans = process( ans, morethan);
        ans = process( ans, lessthan);
        
       
        return ans;
    }
    public ListNode process(ListNode ans, Stack<ListNode> nodeset)
    {
        while( !nodeset.empty())
        {
            if(ans == null)
                ans = new ListNode(nodeset.pop().val);
            else
            {
                ListNode node = new ListNode(nodeset.pop().val);
                node.next = ans;
                ans = node;
            }
        }
        
        return ans;
    }
}
