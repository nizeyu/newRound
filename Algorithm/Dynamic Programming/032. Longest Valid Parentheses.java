public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        
        // dp initial with all '0'
        int[] dp = new int[len];
        
        // mark all "()" in dp to '1'
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == '(' && s.charAt(i+1) == ')') {
                dp[i] = 1;
                dp[i+1] = 1;
                i++;
            }
        }
        
        // record the start and end index of all range '1' in dp to a q
        Queue<Integer> q = new LinkedList<>();
        boolean flag = true;
        for (int i = 0; i < len; i++) {
            if (flag && dp[i] == 1) {
                q.offer(i);
                flag = !flag;
            }
            
            if (!flag) {
                if (dp[i] == 0) {
                	q.offer(i-1);
                	flag = !flag;
                } else if (i == len - 1) {
                    q.offer(i);
                    flag = !flag;
                }  
            }
        }
        
        // expand according (P) for each range '1'
        int l = 0; // initial l
        while (!q.isEmpty()) {
            
            int start = q.poll();
            int end = q.poll();
            
            // initial r
            int r = dp.length - 1;
            if (!q.isEmpty()) {
                r = q.peek() - 1;
            }
            
            while (start > l && end < r) {
                if (s.charAt(start-1) == '(' && s.charAt(end+1) == ')') {
                    start--;
                    end++;
                    
                    dp[start] = 1;
                    dp[end] = 1;
                } else {
                    break;
                }
                
                // modify end and r
                if (end == r && !q.isEmpty()) {
                    q.poll();
                    end = q.poll();
                    
                    r = dp.length - 1;
                    if (!q.isEmpty()) {
                        r = q.peek() - 1;
                    }
                }
                
                // modify start and l
                if (start == l && l != 0) {
                    while (l != 0 && dp[l-1] == 1) {
                        l--;
                    }
                    start = l;
                    while (l != 0 && dp[l-1] == 0) {
                        l--;
                    }
                }
            }
            // modify l
            l = end + 1;
        }
            
        int max = 0;
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }
}
