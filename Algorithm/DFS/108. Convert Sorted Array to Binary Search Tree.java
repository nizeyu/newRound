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
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return null;
        
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int l, int r)
    {
        if(l > r)
            return null;
            
        int m = l + (r - l) / 2;
                TreeNode root = new TreeNode(nums[m]);
        TreeNode left = sortedArrayToBST(nums, l, m-1);
        TreeNode right = sortedArrayToBST(nums, m+1, r);
        

        root.left = left;
        root.right = right;
        
        return root;
    }
}
