public class IntegerBreak343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            int tmp = 0;
            for (int j=1; j<i; j++) {
                int k = i - j;
                tmp = Math.max(tmp, j * k);
                tmp = Math.max(tmp, j * dp[k]);
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

    public int integerBreak2(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int product = 1;
        while(n>4){
            product*=3;
            n-=3;
        }
        product*=n;
        
        return product;
    }

}
