/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> result = new Stack<>();
        
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            int x = !stack1.isEmpty()?stack1.pop(): 0;
            int y = !stack2.isEmpty()?stack2.pop(): 0;
            
            int digit = x + y + carry;
            
            carry = digit / 10;
            
            result.push(digit % 10);
        }
 
        if(carry != 0)
            result.push(carry);
        
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        
        while(!result.isEmpty()) {
            int v = result.pop();
            p.next = new ListNode(v);
            p = p.next;
        }
        
        return dummyNode.next;
    }
}
