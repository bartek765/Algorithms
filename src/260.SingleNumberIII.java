class Solution {
    public int[] singleNumber(int[] nums) {
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        int rightmostSetBit = xorResult & -xorResult;
        int firstUniqueNumber = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                firstUniqueNumber ^= num;
            }
        }
        int secondUniqueNumber = xorResult ^ firstUniqueNumber;

        return new int[] {firstUniqueNumber, secondUniqueNumber};
    }
}
