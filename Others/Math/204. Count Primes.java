public class Solution
{
    public int countPrimes(int n)
    {
        if(n < 3)
            return 0;
        
        int count = 0;
        
        boolean[] isPrime = new boolean[n]; //false indicate "is prime"

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isPrime[i] == false) {
				for (int j = i; j * i < n; j++) {
					isPrime[j * i] = true;
				}
			}
		}
		
		for(int i = 2; i < n; i++)
		{
		    if(isPrime[i] == false)
		        count++;
		}
        
        return count;
    }
}
