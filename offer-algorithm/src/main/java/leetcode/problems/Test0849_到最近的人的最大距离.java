package leetcode.problems;

import java.util.TreeSet;

public class Test0849_到最近的人的最大距离 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(new Solution().maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(new Solution().maxDistToClosest(new int[]{0, 1}));
        System.out.println(new Solution().maxDistToClosest(new int[]{1, 0, 1}));
    }

    static class Solution {
        public int maxDistToClosest(int[] seats) {
            int len = seats.length;
            int max = 1;
            // 计算连续0的最长长度
            // 前后部分
            int idx1 = 0;
            while (seats[idx1] == 0 && idx1 < len) {
                idx1++;
                max = Math.max(max, idx1);
            }
            int idx2 = 0;
            while (seats[len - 1 - idx2] == 0 && len - 1 - idx2 >= 0) {
                idx2++;
                max = Math.max(max, idx2);
            }
            // 中间部分
            int zeroCnt = 0;
            for (int i = 0; i < len; i++) {
                if (seats[i] == 1) {
                    zeroCnt = 0;
                    continue;
                }
                zeroCnt++;
                max = Math.max(max, (zeroCnt + 1) / 2);
            }
            return max;
        }
    }

    static class Solution2 {
        public int maxDistToClosest(int[] seats) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < seats.length; i++) {
                if (seats[i] > 0) {
                    treeSet.add(i);
                }
            }
            int max = 1;
            for (int seat = 0; seat < seats.length; seat++) {
                if (seats[seat] == 1) {
                    continue;
                }

                int leftDisatnce;
                Integer lastSeat = treeSet.lower(seat);
                if (lastSeat == null) {
                    leftDisatnce = Integer.MAX_VALUE;
                } else {
                    leftDisatnce = seat - lastSeat;
                }

                int rightDistance;
                Integer nextSeat = treeSet.higher(seat);
                if (nextSeat == null) {
                    rightDistance = Integer.MAX_VALUE;
                } else {
                    rightDistance = nextSeat - seat;
                }
                max = Math.max(max, Math.min(leftDisatnce, rightDistance));
            }
            return max;
        }
    }

}
