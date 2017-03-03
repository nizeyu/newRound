//My Soluton: Brute Force
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;
        else if(haystack.length() == 0)
            return -1;
        else if(needle.length() == 0)
            return 0;
        
        int j = 0;
        for(int i = 0; i < haystack.length(); i++) {
            if(haystack.length() - i + 1 < needle.length())
                return -1;
                
            int k = i;
            while(k < haystack.length() && haystack.charAt(k) == needle.charAt(j)) {
                if(j == needle.length() - 1)
                    return k - needle.length() + 1;
                k++;
                j++;
            }
            j = 0;
        }
        return - 1;
    }
}

//Discuss
public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; ;i++) {
            for(int j = 0; ;j++) {
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i+j)) break;
            }
        }
    }
}
