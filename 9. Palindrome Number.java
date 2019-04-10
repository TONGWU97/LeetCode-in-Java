/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
Example 1:
Input: 121
Output: true
Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
*/

// use String
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        String s = String.valueOf(x);
        StringBuffer sb = new StringBuffer(s);
        System.out.print(s);
        if(sb.reverse().toString().equals(s)) {
            return true;
        }
        return false;
    }
}

// not use String
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        return x == reverse(x);
    }
    
    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}