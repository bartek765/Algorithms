class Solution {
    public int dominantIndex(int[] nums) {

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int indexOfMax = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {

                secondMax = max;
                max = nums[i];

                indexOfMax = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return max >= secondMax * 2 ? indexOfMax : -1;
    }
}
