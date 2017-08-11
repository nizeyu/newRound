public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int level = 0;
        Set<String> visited = new HashSet<>();    
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        
        while (!q.isEmpty()) {
            level++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                
                char[] strArray = str.toCharArray();
                
                for (int j = 0; j < strArray.length; j++) {
                    char record = strArray[j];
                    for (int k = 0; k < 4; k++) {
                        if (charSet[k] == record) {
                            continue;
                        }
                        strArray[j] = charSet[k];
                        String newStr = String.valueOf(strArray);
                        if (bankSet.contains(newStr) && newStr.equals(end)) {
                            return level;
                        }
                        if (visited.contains(newStr)) {
                            continue;
                        }
                        if (bankSet.contains(newStr)) {
                            q.offer(newStr);
                            visited.add(newStr);
                        }
                        strArray[j] = record;
                    }  
                }
            }   
        }   
        return -1;            
    }
}
