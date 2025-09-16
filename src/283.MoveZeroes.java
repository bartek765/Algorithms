public class Solution {
    public void moveZeroes(int[] nums) {
        int expand = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[expand] = nums[i];
                expand++;
            } 
        }
        
        int start = expand;
        
        for(; start<nums.length; start++){
            nums[start] = 0;
        }   
    }
}
