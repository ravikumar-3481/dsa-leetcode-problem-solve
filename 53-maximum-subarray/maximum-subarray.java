class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = 0, max_sum = nums[0];
        for (int val : nums) {
            curr_sum += val;
            max_sum = Math.max(max_sum, curr_sum);
            if (curr_sum < 0){
                curr_sum = 0;
            }
        }
        return max_sum;
    }
}