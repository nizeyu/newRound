//Math: https://zh.wikipedia.org/wiki/%E6%95%B8%E6%A0%B9
public class Solution {
    public int addDigits(int num) {
        if(num == 0)
            return 0;
            
        if(num % 9 == 0)
            return 9;
        else
            return num % 9;
    }
}

//My Solution
class Solution {
public:
    int addDigits(int num) {
        int sum = 0;
        while(num != 0){
            int t = num % 10;
            sum = sum + t;
            num = num/10;
        }
        if(sum < 10){
            return sum;
        }else{
            addDigits(sum);
        }
        
    }
};
