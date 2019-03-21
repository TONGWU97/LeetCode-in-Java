/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
*/

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
      if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
          return false;
      }
      
      int length = matrix.length,
          subArrLength = matrix[0].length;
      int start = 0, end = length - 1;
      while(start + 1 < end) {
          int mid = start + (end - start) / 2;
          if(matrix[mid][0] == target) {
              return true;
          } else if (matrix[mid][0] < target) {
              start = mid;
          } else {
              end = mid;
          }
      }
      if(matrix[end][0] <= target) {
          length = end;
      } else if(matrix[start][0] <= target) {
          length = start;
      } else {
          return false;
      }
      
      start = 0;
      end = subArrLength - 1;
      while(start + 1 < end) {
          int mid = start + (end - start) / 2;
          if(matrix[length][mid] == target) {
              return true;
          } else if (matrix[length][mid] < target) {
              start = mid;
          } else {
              end = mid;
          }
      }
      if(matrix[length][start] == target) {
          return true;
      } else if (matrix[length][end] == target) {
          return true;
      }
      return false;
  }
}