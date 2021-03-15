/* You are given the head of a linked list, and an integer k.
 * Return the head of the linked list after swapping the values of the kth node from 
 * the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 *
 * Example 3:
 *
 * Input: head = [1], k = 1
 * Output: [1]
 *
 * Example 4:
 * Input: head = [1,2], k = 1
 * Output: [2,1]
 * 
 * Example 5:
 * Input: head = [1,2,3], k = 2
 * Output: [1,2,3]
 *
 * Constraints:
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 105
 * 0 <= Node.val <= 100
*/

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        
        List<Integer> list = new ArrayList<Integer>();
       
        while(head != null)
        {
            list.add(head.val);
            head = head.next;
        }
        
        int first_k = list.get(k-1);
        int second_k = list.get(list.size() -k);
        list.set(k-1,second_k);
        list.set(list.size() -k, first_k);
        
        ListNode ans = null;
        
        for(int i=list.size()-1; i>=0; i--)
        {
            
           ListNode node = new ListNode(list.get(i));
           
            if(ans == null)
               ans = node;
           else
               node.next = ans;
            
            ans = node;
        }
        
        return ans;
    }
}
