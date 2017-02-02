//My Solution
public class Solution
{
    public String licenseKeyFormatting(String S, int K)
    {
        int k = K;
        StringBuilder sb = new StringBuilder();
        for(int i = S.length() - 1; i >= 0; i--)
        {
            char c = S.charAt(i);
            if(c == '-')
                continue;
            else
            {
                if(k == 0)
                {
                    sb.insert(0, '-');
                    k = K;
                }
                if(c >= 'a' && c <= 'z')
                    c = Character.toUpperCase(c);
                sb.insert(0, c);
                k--;
            }
        }
        return sb.toString();
    }
}
