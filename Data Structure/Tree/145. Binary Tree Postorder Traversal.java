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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                res.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
        return res;
    }
}
 
 //Method 1: Traverse
 public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    
    private void postorder(TreeNode node, List<Integer> res) {
        if(node == null)
            return;
        
        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }
}

//Method 1: Divide & Conquer
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null)
            return res;
    
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
    
        return res;
    }
}
