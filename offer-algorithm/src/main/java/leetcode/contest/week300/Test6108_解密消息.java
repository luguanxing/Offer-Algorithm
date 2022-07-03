package leetcode.contest.week300;

import java.util.Arrays;

public class Test6108_解密消息 {

    public static void main(String[] args) {
        System.out.println(new Solution().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
        System.out.println(new Solution().decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    static class Solution {
        public String decodeMessage(String key, String message) {
            char[] map = new char[26];
            Arrays.fill(map, ' ');
            int index = 0;
            for (char c : key.toCharArray()) {
                if (Character.isAlphabetic(c) && map[c - 'a'] == ' ') {
                    map[c - 'a'] = (char) ('a' + index++);
                }
            }
            String res = "";
            for (char c : message.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    res += map[c - 'a'];
                } else {
                    res += c;
                }
            }
            return res;
        }
    }

}
