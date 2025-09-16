class Solution {
    public int fib(int n) {
        int[] numbers = new int[n + 1];
        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }
        return numbers[n];
    }
}
