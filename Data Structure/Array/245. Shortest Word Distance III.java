//My Solution
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int m = -1;
        int n = -1;
        int pre = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1))
                m = i;
            
            if(words[i].equals(word2))
                n = i;
            
            if(m != -1 && n != -1) {
                if(m == n) {
                    if(pre != -1 && m != pre) {
                        min = Math.min(min, m - pre); 
                    }
                    pre = m;
                } else {
                    min = Math.min(min, Math.abs(m - n));
                }
            }
        }
        return min;
    }
}
