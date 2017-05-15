public class Solution {
    public String reverseStr(String s, int k) {
        if(s == null || s.length() == 0)
            return s;
        
        int n = s.length();
        char[] array = s.toCharArray(); 
        for(int i = 0; i < n; i += 2 * k) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(array, i, j);
        }
        
        return String.valueOf(array);
    }
    
    private void reverse(char[] array, int i, int j) {
        while(i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
