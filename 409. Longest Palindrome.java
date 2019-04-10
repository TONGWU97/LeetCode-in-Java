/* 
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Note:
Assume the length of given string will not exceed 1,010.
Example:
Input:
"abccccdd"
Output:
7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        // 利用hashMap的key value，依次将s每个字符存进key
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if(hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
            
        }
        boolean meetodd = false;
        for(int value : hashMap.values()) {
            if(value % 2 == 0) {
                maxLength += value;
            } else if(meetodd) {
                maxLength += value-1;
            } else {
                meetodd = true;
                maxLength += value;
            }
        }
        return maxLength;
    }
}