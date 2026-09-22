class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        // int curr_sum = nums[0];
        int max_sum = nums[0], maxi = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_sum = Math.max(nums[i], max_sum + nums[i]);

            if (max_sum > maxi) {
                maxi = max_sum;
            }
        }


        return maxi;
    }
}