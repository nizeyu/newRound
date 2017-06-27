// Improved: DP
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // traverse the coins
        for (int i = 0; i < coins.length; i++) {
            // for each number of each typy coins, traverse the dp, find different combinations, modify the dp[]
            
            // add a to corresponding location in dp
            if (coins[i] < dp.length) {
                dp[coins[i]] = Math.min(dp[coins[i]], 1);
            }
            
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] != Integer.MAX_VALUE && j < dp.length - coins[i]) {
                    dp[j+coins[i]] = Math.min(dp[j+coins[i]], 1 + dp[j]);
                }
            }
        }
        
        if (dp[dp.length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dp[dp.length - 1];
    }
}

// My Solution : DP
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // traverse the coins
        for (int i = 0; i < coins.length; i++) {
            // for each number of each typy coins, traverse the dp, find different combinations, modify the dp[]
            int a = coins[i];
            int count = 1;
            while (a <= amount) {
                for (int j = dp.length - 1; j >= 0; j--) {
                    if (dp[j] != Integer.MAX_VALUE && j+a < dp.length) {
                        dp[j+a] = Math.min(dp[j+a], count + dp[j]);
                    }
                }
                
                // add a to corresponding location in dp
                dp[a] = Math.min(dp[a], count);
                a += coins[i];
                count++;
            }
        }
        
        if (dp[dp.length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dp[dp.length - 1];
    }
}

// Similar : 0/1 背包
public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        int[] dp = new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // traverse the coins
        for (int i = 0; i < coins.length; i++) {
            // for each number of each typy coins, traverse the dp, find different combinations, modify the dp[]
            int a = coins[i];
            int count = 1;
            while (a <= amount) {
                for (int j = dp.length - 1; j >= 0; j--) {
                    if (dp[j] != Integer.MAX_VALUE && j+a < dp.length) {
                        dp[j+a] = Math.min(dp[j+a], count + dp[j]);
                    }
                }
                
                // add a to corresponding location in dp
                dp[a] = Math.min(dp[a], count);
                a += coins[i];
                count++;
            }
        }
        
        if (dp[dp.length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return dp[dp.length - 1];
    }
}

// Brute Force 1: DFS
public class Solution {
    public int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        
        Arrays.sort(coins);
        backtracking(0, 0, coins, amount);
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        
        return min;
    }
    
    private void backtracking(int startIndex, int count, int[] coins, int remainAmount) {
        // get result
        if (remainAmount == 0) {
            min = Math.min(min, count);
            //System.out.println(min);
            return;
        }
        
        // backtracking
        for (int i = startIndex; i < coins.length; i++) {
            if (remainAmount < 0) {
                break;
            }
            
            // System.out.println(remainAmount);
            remainAmount -= coins[i];
            count++;
            backtracking(i, count, coins, remainAmount);
            remainAmount += coins[i];
            count--;
        }
    }
}

// Brute Force 2: DFS
public class Solution {
    public int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        
        helper(0, 0, coins, amount);
        
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        
        return min;
    }
    
    private void helper(int start, int count, int[] coins, int amount) {
        // get results
        if (amount < 0) {
            return;
        }
        
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        
        // recursive
        if (start < coins.length) {
            for (int i = 0; ; i++) {
                amount -= i * coins[start];
                count += i;
                helper(start+1, count, coins, amount);
                if (amount <= 0) {
                    break;
                }
                count -= i;
                amount += i * coins[start];
            }
        }
    }
}
