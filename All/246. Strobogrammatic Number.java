//My Solution
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0)
            return false;
        
        char[] array = num.toCharArray();
        int i = 0;
        int j = array.length - 1;
        while(i <= j) {
            if(array[i] == '0') {
                if(array[j] != '0')
                    return false;
            } else if(array[i] == '1') {
                if(array[j] != '1')
                    return false;
            } else if(array[i] == '8') {
                if(array[j] != '8')
                    return false;
            } else if(array[i] == '6') {
                if(i == j || array[j] != '9') {
                    return false;
                } 
            } else if(array[i] == '9') {
                if(i == j || array[j] != '6') {
                    return false;
                } 
            } else {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0)
            return false;
        
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int i = 0;
        int j = num.length() - 1;
        while(i <= j) {
            if(!map.containsKey(num.charAt(i)))
                return false;
            if(map.get(num.charAt(i)) != num.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
