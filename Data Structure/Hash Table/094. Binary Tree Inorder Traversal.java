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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        inorderTraversal(root, result);
        
        return result;
    }
    
    private void inorderTraversal(TreeNode node, List<Integer> result)
    {
        if(node == null)
            return;
        else
        {
            inorderTraversal(node.left, result);
            result.add(node.val);
            inorderTraversal(node.right, result);
        }
    }
}
