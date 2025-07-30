class Solution {
    public boolean checkPerfectNumber(int num) {
        // If the number is 1, it's not a perfect number by definition
        if (num == 1) {
            return false;
        }
      
        int sumOfDivisors = 1; // Start with 1 since it's a divisor of every number
      
        // Loop through possible divisors from 2 to sqrt(num)
        for (int i = 2; i * i <= num; ++i) {
            // If i is a divisor of num
            if (num % i == 0) {
                sumOfDivisors += i; // Add the divisor
                // Add the complement divisor only if it's different from i
                if (i != num / i) {
                    sumOfDivisors += num / i;
                }
            }
        }
      
        // A perfect number equals the sum of its divisors (excluding itself)
        return sumOfDivisors == num;
    }
}
