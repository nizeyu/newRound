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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);//pay attention!preorder.length-1
    }
    
    private TreeNode buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR)
    {
        if(pL > pR || iL > iR)
            return null;
        
        int val = preorder[pL];
        TreeNode root = new TreeNode(val);
        
        int k = 0;
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == val)
            {
                k = i;
                break;
            }
        }
        
        root.left = buildTree(preorder, pL+1, pL+k-iL, inorder, iL, iL+k-1);//pay attention! pL+k-iL
        root.right = buildTree(preorder, pL+k-iL+1, pR, inorder, k+1, iR);
        
        return root;
    }
}
