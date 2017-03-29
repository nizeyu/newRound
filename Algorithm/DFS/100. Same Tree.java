//My Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null)
            return false;
        else if(q == null)
            return false;
        
        if(p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}

//Non recursive Solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack_p = new Stack<>();
        Stack<TreeNode> stack_q = new Stack<>();
        if(p != null) stack_p.push(p);
        if(q != null) stack_q.push(q);
        
        while(!stack_p.isEmpty() && !stack_q.isEmpty()) {
            TreeNode np = stack_p.pop();
            TreeNode nq = stack_q.pop();
            if(np.val != nq.val) return false;
            
            if(np.right != null) stack_p.push(np.right);
            if(nq.right != null) stack_q.push(nq.right);
            if(stack_p.size() != stack_q.size()) return false;
            
            if(np.left != null) stack_p.push(np.left);
            if(nq.left != null) stack_q.push(nq.left);
            if(stack_p.size() != stack_q.size()) return false;
        }
        return stack_p.size() == stack_q.size();
    }
}
