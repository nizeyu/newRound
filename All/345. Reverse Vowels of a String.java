//My Solution
public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() == 0)
            return s;
        
        String vowels = "aeiouAEIOU";   
        char[] array = s.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while(i < j) {
            while(i < j && !vowels.contains(array[i] + ""))
                i++;
            
            while(i < j && !vowels.contains(array[j] + ""))
                j--;
            
            Character t = array[i];
            array[i] = array[j];
            array[j] = t;
            
            i++;
            j--;
        }
        return new String(array);
    }
}
