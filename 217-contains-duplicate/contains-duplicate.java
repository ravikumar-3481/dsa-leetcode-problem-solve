class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ns = new HashSet<>();

        for (int n : nums) {
            if (ns.contains(n)) {
                return true;
            }
            ns.add(n);
        }

        return false;
    }
}