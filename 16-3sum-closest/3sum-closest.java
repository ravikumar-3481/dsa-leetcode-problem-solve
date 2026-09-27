class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            // 1. Skip duplicate values for the fixed first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 2. Early Pruning: Minimum possible sum with current nums[i]
            int minSum = nums[i] + nums[i + 1] + nums[i + 2];
            if (minSum > target) {
                if (Math.abs(target - minSum) < Math.abs(target - result)) {
                    result = minSum;
                }
                // Since array is sorted, any subsequent triplets will only yield larger sums
                break; 
            }

            // 3. Early Pruning: Maximum possible sum with current nums[i]
            int maxSum = nums[i] + nums[n - 2] + nums[n - 1];
            if (maxSum < target) {
                if (Math.abs(target - maxSum) < Math.abs(target - result)) {
                    result = maxSum;
                }
                // Larger sums for this nums[i] aren't possible; skip to next i
                continue; 
            }

            // 4. Two-Pointer Approach
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }

                if (sum == target) {
                    return target; // Exact match found
                } else if (sum < target) {
                    left++;
                    // Skip duplicates for the left pointer
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else {
                    right--;
                    // Skip duplicates for the right pointer
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}