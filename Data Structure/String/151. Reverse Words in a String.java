//My solution
public class Solution
{
    public String reverseWords(String s)
    {
        String[] words = s.trim().split("\\s+");
        int i = 0;
        int j = words.length - 1;
        
        while(i < j)
        {
            swap(words, i, j);
            i++;
            j--;
        }
        
        StringBuilder sb = new StringBuilder(); 
        
        for(int k = 0; k < words.length; k++)
        {
            sb.append(words[k]);
            if(k + 1 < words.length)
                sb.append(" ");
        }
            
        return sb.toString();
    }
    
    public void swap(String[] words, int i, int j)
    {
        String temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
