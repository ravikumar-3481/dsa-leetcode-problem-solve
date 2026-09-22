class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        longest = 0
        num_set = set(nums)

        for num in num_set:
            if (num - 1) not in num_set:
                curr = num + 1
                 

                while curr in num_set:
                    curr += 1

                count = curr - num
                if count > longest:
                    longest = count

        return longest      