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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        
        while(root != null) {
            List<Integer> list = new ArrayList<>();
            if(dfs(root, list))
                root = null;
            res.add(list);
        }
        return res;
    }
    
    private boolean dfs(TreeNode root, List<Integer> list) {
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return true;
        }
        
        if(root.left != null) {
            if(dfs(root.left, list)) 
                root.left = null;
        }
        
        if(root.right != null) {
            if(dfs(root.right, list))
                root.right = null;
        }
        return false;
    }
}
