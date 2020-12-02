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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    List<Integer> list = new ArrayList<Integer>();
    
    public Solution(ListNode head) {
        
       list.add(head.val);
        ListNode node = head;
        
        while(node.next != null)
        {
            list.add(node.next.val);
            node = node.next;
        }
        
        
        
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
         int upperbound = list.size();
        //generate random values from 0 to upperbound-1
      int int_random = rand.nextInt(upperbound); 
        
        
        return list.get(int_random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
