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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()) {
            depth++;
            int size= q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                
                if(node.left == null && node.right == null)
                    return depth;
                
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
        }
        return 1;
    }
}

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
    public int minDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Queue<Integer> depth = new LinkedList<>();
        depth.offer(1);
        
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            int d = depth.poll();
            
            if(node.left == null && node.right == null)
                return d;
                
            if(node.left != null)
            {
                q.offer(node.left);
                depth.offer(d + 1);
            }
                
            if(node.right != null)
            {
                q.offer(node.right);
                depth.offer(d + 1);
            }
                
        }
        return 1;
    }
}
