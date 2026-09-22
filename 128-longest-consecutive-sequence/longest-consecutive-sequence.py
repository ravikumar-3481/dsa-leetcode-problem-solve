class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        longest = 0
        num_set = set(nums)

        for num in num_set:
            if (num - 1) not in num_set:
                curr = num
                count = 1  

                while (curr + 1) in num_set:
                    count+=1
                    curr+=1

                longest = max(longest, count)

        return longest      