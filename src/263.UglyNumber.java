class Solution {
    public boolean isUgly(int num) {
        int[] ugly = { 2, 3, 5 };
        for (int u : ugly) {
            while (num % u == 0 && num % u < num) {
                num /= u;
            }
        }
        return num == 1;
    }
}
