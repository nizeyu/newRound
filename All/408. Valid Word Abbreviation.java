//My Solution
public class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while(i < word.length() && j < abbr.length()) {
            char a = abbr.charAt(j);
            if(Character.isLowerCase(a)) {
                char w = word.charAt(i);
                if(a != w)
                    return false;
                i++;
                j++;
            } else {
                int n = 0;
                if(abbr.charAt(j) == '0')
                    return false;
                while(j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    n = 10 * n + Character.getNumericValue(abbr.charAt(j));
                    j++;
                }
                i += n;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
