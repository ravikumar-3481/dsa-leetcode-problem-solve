
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (pairIdx.containsKey(target - nums[i])) {
                return new int[] {i, pairIdx.get(target - nums[i])} ;
            }
            pairIdx.put(nums[i], i);
        }
        return new int[] {};
    }
}