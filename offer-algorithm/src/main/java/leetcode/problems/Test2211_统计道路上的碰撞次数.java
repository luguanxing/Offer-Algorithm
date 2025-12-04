package leetcode.problems;

import java.util.TreeSet;

public class Test2211_统计道路上的碰撞次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countCollisions("RLRSLL"));
        System.out.println(new Solution().countCollisions("LLRR"));
        System.out.println(new Solution().countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

    static class Solution {
        public int countCollisions(String directions) {
            int len = directions.length();
            char[] chars = directions.toCharArray();
            // 先去掉开头的L和结尾的R，然后剩下非S的都要碰撞
            int l = 0;
            int r = len - 1;
            while (l < len && chars[l] == 'L') {
                l++;
            }
            while (r >= 0 && chars[r] == 'R') {
                r--;
            }
            int cnt = 0;
            for (int i = l; i <= r; i++) {
                if (chars[i] != 'S') {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    static class Solution_记路障 {
        public int countCollisions(String directions) {
            int len = directions.length();
            // 记下反方向或S的下表
            TreeSet<Integer> againstLeft = new TreeSet<>();
            TreeSet<Integer> againstRight = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                char c = directions.charAt(i);
                if (c == 'R' || c == 'S') {
                    againstLeft.add(i);
                }
                if (c == 'L' || c == 'S') {
                    againstRight.add(i);
                }
            }
            // 对于每个L或R，找出其最近的反方向或S，计算碰撞次数
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                char c = directions.charAt(i);
                if (c == 'L') {
                    Integer nearest = againstLeft.lower(i);
                    if (nearest != null) {
                        cnt++;
                    }
                } else if (c == 'R') {
                    Integer nearest = againstRight.higher(i);
                    if (nearest != null) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

}
