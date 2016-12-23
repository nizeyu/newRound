public class Solution
{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        
        if(C < E || G < A || H < B || D < F)
            return area;
        
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int overlap = (top - bottom) * (right - left); 
        
        return area - overlap;
    }
}
