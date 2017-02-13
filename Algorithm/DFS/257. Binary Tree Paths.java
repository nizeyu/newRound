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
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> result = new ArrayList<>();
        
        if(root == null)
            return result;
            
        binaryTreePaths(root, String.valueOf(root.val), result);
        
        return result;
    }
    
    private void binaryTreePaths(TreeNode node, String path, List<String> result)
    {
        if(node.left == null && node.right == null)
            result.add(path);
        else
        {
            if(node.left != null)
                binaryTreePaths(node.left, path+"->"+node.left.val, result);
            if(node.right != null)
                binaryTreePaths(node.right, path+"->"+node.right.val, result);
        }
    }
}
