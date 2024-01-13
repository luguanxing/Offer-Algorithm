package leetcode.problems;

public class Test2182_构造限制重复的字符串 {

    public static void main(String[] args) {
        // s = "cczazcc", repeatLimit = 3
        System.out.println(new Solution().repeatLimitedString("cczazcc", 3));
        // s = "aababab", repeatLimit = 2
        System.out.println(new Solution().repeatLimitedString("aababab", 2));
        System.out.println(new Solution().repeatLimitedString("aaaaaaabbbbbb", 1));
    }

    static class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
            }
            char last = getMaxCharFrom(map, 25);
            int cnt = 1;
            map[last - 'a']--;
            StringBuilder res = new StringBuilder("" + last);
            while (cnt <= repeatLimit) {
                char current = getMaxCharFrom(map, 25);
                if (current == ' ') {
                    break;
                }
                if (current == last) {
                    cnt++;
                    if (cnt > repeatLimit) {
                        current = getMaxCharFrom(map, last - 'a' - 1);
                        if (current == ' ') {
                            break;
                        }
                        cnt = 1;
                    }
                } else {
                    cnt = 1;
                }
                res.append(current);
                map[current - 'a']--;
                last = current;
            }
            return res.toString();
        }

        private char getMaxCharFrom(int[] map, int index) {
            for (int i = index; i >= 0; i--) {
                if (map[i] > 0) {
                    return (char) ('a' + i);
                }
            }
            return ' ';
        }
    }

}
