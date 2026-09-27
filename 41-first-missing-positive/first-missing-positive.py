class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        n = len(nums)
        for i in range(n) :
            while 1 <= nums[i] <= n and nums[nums[i] - 1] != nums[i] :
                curr_idx = nums[i] - 1
                nums[i], nums[curr_idx] = nums[curr_idx] , nums[i]

        for i in range(n) :
                if nums[i] != i + 1:
                    return i + 1
        return n + 1