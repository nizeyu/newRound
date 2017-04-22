Method 1: wrong
public class Solution
{
    public String getHint(String secret, String guess)
    {
        Map<Character, Integer> map = new HashMap<>();
        int A = 0, B = 0;
        
        for(int i = 0; i < secret.length(); i++)
            map.put(secret.charAt(i), i);
        
        for(int i = 0; i < guess.length(); i++)
        {
            if(map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) == i)
                A++;
            else if(map.containsKey(guess.charAt(i)))
                B++;
        }
        
        return A + "A" + B + "B";
    }
}

Method 2:
public class Solution
{
    public String getHint(String secret, String guess)
    {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for(int i = 0; i < secret.length(); i++)
        {
            int s = Character.getNumericValue(secret.charAt(i));
            if(secret.charAt(i) == guess.charAt(i))
                bulls++;
            else
                numbers[s]++;
        }
        
        for(int i = 0; i < guess.length(); i++)
        {
            int g = Character.getNumericValue(guess.charAt(i));
            if(secret.charAt(i) != guess.charAt(i) && numbers[g] > 0)
            {
                cows++;
                numbers[g]--;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
