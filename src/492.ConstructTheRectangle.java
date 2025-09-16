class Solution {
    public int[] constructRectangle(int area) {
        int W = 1, L = 1, diff = Integer.MAX_VALUE;
        
        for (int i = 1; i <= area / 2; ++i) {
            if (area % i == 0) {
                int tempW = area / i, tempL = i;
                int tempdiff = Math.abs(tempW - tempL);
                
                if (diff > tempdiff) {
                    diff = tempdiff;
                    W = tempW;
                    L = tempL;
                }
            }
        }
        
        int[] ans = {Math.max(W, L), Math.min(W, L)};
        return ans;
    }
}
