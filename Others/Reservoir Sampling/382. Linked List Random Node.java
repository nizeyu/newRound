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
    private ListNode head;
    private Random random;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head)
    {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom()
    {
        int result = 0;
        ListNode p = head;
        for(int i = 1; p != null; i++, p = p.next)
            if(random.nextInt(i) == 0)
                result = p.val;

        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
