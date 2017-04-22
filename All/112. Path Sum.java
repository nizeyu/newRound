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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> val = new Stack<>();
        stack.push(root);
        val.push(sum - root.val);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int v = val.pop();
            if(node.left == null && node.right == null && v == 0)
                return true;
            
            if(node.right != null) {
                stack.push(node.right);
                val.push(v - node.right.val);
            }
            
            if(node.left != null) {
                stack.push(node.left);
                val.push(v - node.left.val);
            }
        }
        return false;
    }
}

//recursive
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null && sum - root.val == 0)
            return true;
        else
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

//dfs
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if(root == null)
            return false;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> sumValue = new Stack<>();
        sumValue.push(root.val);
        
        while(!stack.isEmpty())
        {
            TreeNode node =  stack.pop();
            int val = sumValue.pop();
            
            if(node.left == null && node.right == null && val == sum)
                return true;
            
            if(node.right != null)
            {
                stack.push(node.right);
                sumValue.push(node.right.val + val);
            }
                
            if(node.left != null)
            {
                stack.push(node.left);
                sumValue.push(node.left.val + val);
            }
                
        }
        return false;
    }
}
