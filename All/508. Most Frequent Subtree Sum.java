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
    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null)
            return new int[0];
            
        List<Integer> list = new ArrayList<>();
        postOrder(root);
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max)
                list.add(entry.getKey());
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = list.get(i);
            
        return res;
    }
    
    private int postOrder(TreeNode root) {
        if(root == null)
            return 0;
        int l = postOrder(root.left);
        int r = postOrder(root.right);
        int sum = l+r+root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}
