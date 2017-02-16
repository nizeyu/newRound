public class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        int k = 0;
        boolean flag = true;
        for(String word : words) {
            flag = true;
            int row = findRow(word.charAt(0)); 
            for(int i = 1; i < word.length(); i++) {
                if(findRow(word.charAt(i)) != row) {
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                res.add(word);
        }
        
        String[] result = new String[res.size()];
        for(int i = 0; i < result.length; i++)
            result[i] = res.get(i);
            
        return result;
    }
    
    private int findRow(Character x) {
        x = Character.toLowerCase(x);
        if(x == 'q' || x == 'w' || x == 'e' || x == 'r' || x == 't' || x == 'y' || x == 'u' || x == 'i' || x == 'o' || x == 'p')
            return 1;
        else if(x == 'a' || x == 's' || x == 'd' || x == 'f' || x == 'g' || x == 'h' || x == 'j' || x == 'k' || x == 'l')
            return 2;
        else
            return 3;
    }
}
