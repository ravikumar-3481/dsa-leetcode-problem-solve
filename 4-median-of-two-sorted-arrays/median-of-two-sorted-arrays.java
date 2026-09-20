import java.util.Random;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int n = n1 + n2 ;
        int[] nums = new int[n];

        System.arraycopy(nums1, 0, nums, 0 ,n1);
        System.arraycopy(nums2, 0, nums, n1 ,n2);
        Random rd = new Random();

        if (n % 2 == 1) {
            return (double) quickselect(nums, n/2, rd);
        }
        double left = (double) quickselect(nums, n/2-1, rd);
        double right = (double) quickselect(nums, n/2, rd);

        return (left + right) / 2.0;
    }

    private int quickselect(int[] nums, int k, Random rd) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot_idx = left + rd.nextInt(right - left + 1) ;
            swap(nums, pivot_idx, right);
            int pivot = nums[right], store = left;

            for (int i = left ; i < right ; i++) {
                if (nums[i] < pivot) {
                    swap(nums, i, store);
                    store++;
                }
            }
            swap(nums, store, right);
            if (store == k) {
                return nums[store];
            }
            if (store < k) {
                left = store + 1;
            } else {
                right = store - 1;
            }
            

        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}