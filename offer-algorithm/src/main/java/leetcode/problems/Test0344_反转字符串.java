package leetcode.problems;

import java.util.Arrays;

public class Test0344_反转字符串 {

    public static void main(String[] args) {
        char[] s1 = "hello".toCharArray();
        char[] s2 = "Hannah".toCharArray();
        new Solution().reverseString(s1);
        new Solution().reverseString(s2);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }

    static class Solution {
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length / 2; i++) {
                char tmp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = tmp;
            }
        }
    }

}
