/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
You may assume no duplicate exists in the array.
Example 1:
Input: [3,4,5,1,2] 
Output: 1
Example 2:
Input: [4,5,6,7,0,1,2]
Output: 0
*/
//二分法
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        int target = nums[nums.length - 1];
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] <= target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }
}

//暴力
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}