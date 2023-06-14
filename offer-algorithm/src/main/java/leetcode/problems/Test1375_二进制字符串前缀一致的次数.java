package leetcode.problems;

import java.util.TreeSet;

public class Test1375_二进制字符串前缀一致的次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numTimesAllBlue(new int[]{3, 2, 4, 1, 5}));
        System.out.println(new Solution().numTimesAllBlue(new int[]{4, 1, 2, 3}));
    }

    static class Solution {
        public int numTimesAllBlue(int[] flips) {
            // 记录点灯个数和最远的灯序号，当最远的灯序号==点灯个数时符合条件
            int cnt = 0;
            int max = 0;
            int res = 0;
            for (int flip : flips) {
                cnt++;
                max = Math.max(max, flip);
                if (max == cnt) {
                    res++;
                }
            }
            return res;
        }
    }

    static class Solution_Set {
        public int numTimesAllBlue(int[] flips) {
            int len = flips.length;
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 1; i <= len; i++) {
                set.add(i);
            }
            int res = 0;
            for (int flip : flips) {
                Integer lowerKey = set.lower(flip);
                int higherKey = set.higher(flip) == null ? 10005 : set.higher(flip);
                if (lowerKey == null && set.size() - 1 == len - higherKey + 1) {
                    res++;
                }
                set.remove(flip);
            }
            return res + 1;
        }
    }

}
