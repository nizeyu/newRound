
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Method 0: Non-Recursion (Recommend)
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(!stack.isEmpty() || p != null) {
            while(p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            res.add(p.val);
            p = p.right;
        }
        return res;
    }
}

//Method 1: Traverse
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res); 
        return res;
    }
    
    private void inorder(TreeNode node, List<Integer> res) {
        if(node == null)
            return;
        
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }
}
