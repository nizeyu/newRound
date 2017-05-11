//BFS
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            
            if(node.left != null)
                q.offer(node.left);
            if(node.right != null)
                q.offer(node.right);
        }
        return root;
    }
}

//My Solution: Recursive
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        
        invert(root);
        return root;
    }
    
    private void invert(TreeNode node) {
        if(node == null)
            return;
        
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        
        invertTree(node.left);
        invertTree(node.right);
    }
}


