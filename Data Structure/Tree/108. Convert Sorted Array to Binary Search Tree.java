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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
            
        TreeNode root = helper(0, nums.length - 1, nums);
        
        return root;
    }
    
    private TreeNode helper(int l, int r, int[] nums) {
        if(r < l)
            return null;
        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(l, mid - 1, nums);
        node.right = helper(mid + 1, r, nums);
        return node;
    }
}
