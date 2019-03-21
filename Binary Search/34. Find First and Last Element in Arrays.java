/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
   Your algorithm's runtime complexity must be in the order of O(log n).
   If the target is not found in the array, return [-1, -1].
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int max = binarySearchMax(nums, target), min = binarySearchMin(nums, target);
        int[] ans = new int[2];
        ans[0] = min;
        ans[1] = max;

        return ans;
    }

    public int binarySearchMax(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    public int binarySearchMin(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1, mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
