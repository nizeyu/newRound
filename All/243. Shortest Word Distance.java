public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int m = -1;
        int n = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1))
                m = i;
            
            if(words[i].equals(word2))
                n = i;
            
            if(m != -1 && n != -1)
                min = Math.min(min, Math.abs(m - n));
        }
        return min;
    }
}
