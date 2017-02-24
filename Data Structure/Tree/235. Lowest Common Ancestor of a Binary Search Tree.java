//Solution: Recursive
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return root;
        
        if(root.val > p.val && root.val < q.val)
            return root;
        else if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}
//Time Complexity - O(logn)， Space Complexity - O(n)

//Solution: 迭代
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null)
            return root;
        
        TreeNode node = root;
        while(node != null) {
            if(node.val > p.val && node.val < q.val)
                return node;
            else if(node.val > p.val && node.val > q.val)
                node = node.left;
            else if(node.val < p.val && node.val < q.val)
                node = node.right;
            else
                break;
        }
        return node;    
    }
}
//Time Complexity - O(logn)， Space Complexity - O(n)
