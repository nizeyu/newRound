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
    public int sumNumbers(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int sum = 0;
        
        List<String> numbers = new ArrayList<>();
        
        getNumbers(root, String.valueOf(root.val), numbers);
        
        for(String number: numbers)
            sum += Integer.valueOf(number);
            
        return sum;
    }
    
    private void getNumbers(TreeNode node, String number, List<String> numbers)
    {
        if(node.left == null && node.right == null)
            numbers.add(number);
        else
        {
            if(node.left != null)
                getNumbers(node.left, number + node.left.val, numbers);
            
            if(node.right != null)
                getNumbers(node.right, number + node.right.val, numbers);
        }
    }
}
