//My Solution: 繁琐了
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode p = head;
        while(p != null && p.next != null) {
            while(p.next != null && p.val == p.next.val)
                p.next = p.next.next;
            p = p.next;
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode p = head;
        while(p != null && p.next != null) {
            if(p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }
}
