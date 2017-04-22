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
    int count = 1;
    int max = 0;
    Integer prev = null;
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        
        List<Integer> list = new LinkedList<>();
        
        inOrder(root, list);
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void inOrder(TreeNode node, List<Integer> list) {
        if(node == null)
            return;
        
        inOrder(node.left, list);
        if(prev != null) {
            if(prev == node.val)
                count++;
            else
                count = 1;
        }
        if(count > max) {
            list.clear();
            list.add(node.val);
            max = count;
        } else if(count == max){
            list.add(node.val);
        }
        prev = node.val;
        inOrder(node.right, list);
    }
}
