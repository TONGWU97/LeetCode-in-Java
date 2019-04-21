/**
 * Narcissistic Number is a number that is the sum of its own digits each raised to the power of the number of digits. See wiki
For example the 3-digit decimal number 153 is a narcissistic number because 153 = 13 + 53 + 33.
And the 4-digit decimal number 1634 is a narcissistic number because 1634 = 14 + 64 + 34 + 44.
Given n, return all narcissistic numbers with n digits.
样例
注意事项
You may assume n is smaller than 8.
 */

public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(n == 1) {
            for(int i = 0; i < 10; i++) {
                list.add(i);
            }
            return list;
        }
        for(int i = pow(10, n-1); i < pow(10, n); i++) {
            int j = i;
            int s = 0;
            while (j > 0) {
                s += pow((j % 10), n);
                j = j / 10;
            }
            if (s == i)
                list.add(i);
        }
        return list;
    }
    
    public int pow(int a, int b) {
        int val = 1;
        for(int i = 1; i <= b; i++) {
            val *= a;
        }
        return val;
    }
}