//My Solution: BFS
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
    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int depth = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            depth++;
        }
        
        return depth;
    }
}

//My Solution: DFS
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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int max = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        stack.push(root);
        depth.push(1);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = depth.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                depth.push(temp + 1);
            }
            if(node.right != null) {
                stack.push(node.right);
                depth.push(temp + 1);
            }
        }
        return max;
    }
}

//My Solution: recursive
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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
