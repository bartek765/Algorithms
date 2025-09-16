import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(new ArrayList<>(), 0, nums, result);
        return result;
    }

    private void generateSubsets(List<Integer> subset, int index, int[] nums, List<List<Integer>> result) {

        result.add(new ArrayList<>(subset));

        for (int i = index; i < nums.length; i++) {

            subset.add(nums[i]);

            generateSubsets(subset, i + 1, nums, result);

            subset.remove(subset.size() - 1);
        }
    }
}
