//Method 1: recursive
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(dfs(head) == 0) {
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    private int dfs(ListNode node) {
        if(node == null)
            return 1;
        
        int carry = dfs(node.next);
        
        if(carry == 0)
            return 0;
        
        int val = node.val + 1;
        node.val = val % 10;
        return val / 10;
    }
}

//Method 2: dummyNode + two points
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        if(dfs(head) == 0) {
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    private int dfs(ListNode node) {
        if(node == null)
            return 1;
        
        int carry = dfs(node.next);
        
        if(carry == 0)
            return 0;
        
        int val = node.val + 1;
        node.val = val % 10;
        return val / 10;
    }
}
