import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer> set = new HashSet<>();
        int longest = 1;
        if (nums.length == 0) return 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int val : set ) {
            if (!set.contains(val - 1)) {
                int count = 1, x = val;
                while (set.contains(x + 1)) {
                    count++ ;
                    x++;
                }
                longest = Math.max(longest, count) ;
            }
        }
        return longest;
    }
}