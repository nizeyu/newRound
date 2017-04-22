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
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode i = dummyNode;
        ListNode j = dummyNode;
        
        while(j.next != null) {
            j = j.next;
            if(j.val != 9)
                i = j;
        }
        
        if(j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while(i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if(dummyNode.val == 0)
            return dummyNode.next;
        
        return dummyNode;
    }
}
