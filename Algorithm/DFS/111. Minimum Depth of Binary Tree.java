
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Method 0
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        return getMin(root);
    }
    
    private int getMin(TreeNode root) {
        if(root == null)
            return Integer.MAX_VALUE;
        
        if(root.left == null && root.right == null)
            return 1;
        
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }
}

//Method 1

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
