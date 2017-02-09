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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return result;
        
        boolean L2R = true;
        Stack<TreeNode> cur = new Stack<>();
        cur.push(root);
        
        while(!cur.isEmpty())
        {
            Stack<TreeNode> next = new Stack<>();
            List<Integer> level = new ArrayList<>();
            while(!cur.isEmpty())
            {
                TreeNode node = cur.pop();
                level.add(node.val);
                
                if(L2R)
                {
                    if(node.left != null)
                        next.push(node.left);
                    if(node.right != null)
                        next.push(node.right);
                }
                else
                {
                    if(node.right != null)
                        next.push(node.right);
                    if(node.left != null)
                        next.push(node.left);
                }
            }
            cur = next;
            L2R = !L2R;
            
            result.add(new ArrayList<>(level));
        }
        return result;
    }
}
