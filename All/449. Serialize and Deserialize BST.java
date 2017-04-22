/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec
{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        if(root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            sb.append(node.val).append(",");
            
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        if (data == null || data.length() == 0) 
            return null;
        String[] str = data.split(",");
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < str.length; i++)
            q.offer(Integer.parseInt(str[i]));
        return getNode(q);
    }
    
    private TreeNode getNode(Queue<Integer> q)
    {
        if(q.isEmpty())
            return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> smallerQueue = new LinkedList<>();
        while(!q.isEmpty() && q.peek() < root.val)
            smallerQueue.offer(q.poll());
        
        root.left = getNode(smallerQueue);
        root.right = getNode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
