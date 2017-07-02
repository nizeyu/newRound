// DP
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    level.add(j);
                    //System.out.print(j + " ");
                }
            }
            //System.out.println("---");
            dp.add(level);
        }
        
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < dp.get(i).size(); j++) {
                if (possible[dp.get(i).get(j)]) {
                    possible[i] = true;
                    break;
                }
            }
            //System.out.println(possible[i]);
        }
        
        dfs(0, new ArrayList<Integer>(), dp, possible, s, wordDict, results);
        
        return results;
    }
    
    private void dfs(int index, List<Integer> path, List<List<Integer>> dp, boolean[] possible, String s, List<String> wordDict, List<String> results) {
        if (!possible[index]) {
            return;
        }
        
        // get result
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            int pre = 0;
            for (int i = 0; i < path.size(); i++) {
                sb.append(s.substring(pre, path.get(i)));
                if (i != path.size() - 1) {
                    sb.append(" ");
                }
                pre = path.get(i);
            }
            results.add(sb.toString());
            return;
        }
        
        
        for (int i = 0; i < dp.get(index).size(); i++) {
            path.add(dp.get(index).get(i));
            dfs(dp.get(index).get(i), path, dp, possible, s, wordDict, results);
            path.remove(path.size() - 1);
        }
       
    }
}

// 超时
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        
        List<List<List<Integer>>> dp = new ArrayList<>();
        dp.add(new ArrayList<List<Integer>>());
        dp.add(new ArrayList<List<Integer>>());
        
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                
                if (!dp.get(j).isEmpty()) {
                    if (wordDict.contains(sub)) {
                        for (List<Integer> list : dp.get(j)) {
                            list.add(i);
                            dp.get(i).add(new ArrayList<>(list));
                            list.remove(list.size()-1);
                        }
                    }
                } else if (j == 0) {
                    if (wordDict.contains(sub)) {
                        List<Integer> l = new ArrayList<>();
                        l.add(i);
                        dp.get(i).add(l);
                    }
                }
            }
            dp.add(new ArrayList<List<Integer>>());
        }
        
        List<String> results = new ArrayList<>();
        for (List<Integer> list : dp.get(s.length())) {
            StringBuilder sb = new StringBuilder();
            int pre = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = pre; j < list.get(i); j++) {
                    sb.append(s.charAt(j));
                }
                
                if (i != list.size() - 1) {
                    sb.append(" ");
                }
                
                pre = list.get(i);
            }
            results.add(sb.toString());
        }
        
        return results;
    }
}
