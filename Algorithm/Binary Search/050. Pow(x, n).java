class Solution {
    public double myPow(double x, int n) {
          long N = (long)n;
          if (N >= 0) {
              return powPositive(x, N);
          } else {
              return 1 / powPositive(x, -N);
          }
    }
    
    public double powPositive(double x, long N) {
        if (N == 0) {
            return 1;
        }
        
        double res = powPositive(x, N/2);
        
        if (N % 2 == 0) {
            return res * res;
        } else {
            return x * res * res;
        }
    }
}
