//特殊方法
public class Solution {
    public int[] findPermutation(String s) {
        int[] arr = new int[s.length()+1];
        for(int i = 0; i < arr.length; i++)
            arr[i] = i + 1;
        
        for(int r = 0; r < s.length(); r++) {
            if(s.charAt(r) == 'D') {
                int l = r;
                while(r < s.length() && s.charAt(r) == 'D')
                    r++;
                reverse(arr, l, r);
            }
        }
        return arr;
    }
    
    private void reverse(int[] arr, int l, int r) {
        while(l < r) {
            arr[l] ^= arr[r];
            arr[r] ^= arr[l];
            arr[l] ^= arr[r];
            l++;
            r--;
        }
    }
}

//My Solution: backtracking TLE
public class Solution {
    boolean stop = false; 
    public int[] findPermutation(String s) {
        if(s == null || s.length() == 0)
            return new int[0];
            
        int[] res = new int[s.length() + 1];
        
        
        backtracking(s, new ArrayList<Integer>(), new boolean[s.length() + 2], res);
        
        return res;
    }
    
    private void backtracking(String s, List<Integer> temp, boolean[] used, int[] res) {
        if(temp.size() == res.length) {
            stop = true;
            for(int i = 0; i < res.length; ++i) {
                res[i] = temp.get(i);
                //System.out.print(res[i] + " ");
            }
            //System.out.println();
            return;
            } else {
            for(int i = 1; i <= s.length() + 1; i++) {
                if(used[i] == false) {
                    temp.add(i);
                    if(temp.size() > 1) {
                        char c = s.charAt(temp.size()-2);
                        if((c == 'I' && temp.get(temp.size()-2) > temp.get(temp.size()-1)) || (c == 'D' && temp.get(temp.size()-2) < temp.get(temp.size()-1))) {
                            temp.remove(temp.size()-1);
                            continue;
                        }
                    }
                    used[i] = true;
                    backtracking(s, temp, used, res);
                    if(stop == true)
                        return;
                    used[i] = false;
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
}
