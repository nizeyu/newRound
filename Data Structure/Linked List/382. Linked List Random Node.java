/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    ListNode head;
    Random random = new Random();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head)
    {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom()
    {
        ListNode p = head;
        int length = 0;
        while(p.next != null)
        {
            p = p.next;
            length++;
        }
        p= head;
        int index = random.nextInt(length+1); 
        while(index > 0)
        {
            p = p.next;
            index--;
        }
        return p.val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
