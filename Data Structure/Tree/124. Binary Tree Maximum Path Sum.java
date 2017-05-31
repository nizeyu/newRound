//Divide & Conquer
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    int root2any, any2any;
    public ResultType(int root2any, int any2any) {
        this.root2any = root2any;
        this.any2any = any2any;
    }
} 
 
public class Solution {
    public int maxPathSum(TreeNode root) {
        ResultType res = helper(root);
        return res.any2any;
    }
    
    private ResultType helper(TreeNode root) {
        //Illegal
        if(root == null)
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        
        //Divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //Conquer
        int root2any = Math.max(0, Math.max(left.root2any, right.root2any)) + root.val;
        
        int any2any = Math.max(left.any2any, right.any2any);
        
        any2any = Math.max(any2any, 
                            Math.max(0, left.root2any) + Math.max(0, right.root2any) + root.val);
        
        return new ResultType(root2any, any2any);
    }
}
