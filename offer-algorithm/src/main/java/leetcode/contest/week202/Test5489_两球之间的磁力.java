package leetcode.contest.week202;

import java.util.Arrays;

public class Test5489_两球之间的磁力 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(new Solution().maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(new Solution().maxDistance(new int[]{79, 74, 57, 22}, 4));
    }

    static class Solution {
        public int maxDistance(int[] position, int m) {
            // "最小值最大"或者"最大值最小"的问题，想到二分
            Arrays.sort(position);
            int maxDistance = (position[position.length - 1] - position[0]) / (m - 1);
            int minDistance = 1;
            while (minDistance < maxDistance) {
                int midDistance = (maxDistance + minDistance) / 2;
                if (checkDistance(position, midDistance, m)) {
                    minDistance = midDistance + 1;
                } else {
                    maxDistance = midDistance - 1;
                }
            }
            return checkDistance(position, minDistance, m) ? minDistance : minDistance - 1;
        }

        private boolean checkDistance(int[] position, int midDistance, int limit) {
            // 计算以midDistance为距离能放的球是否满足条件
            int count = 1;
            int lastI = 0;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - position[lastI] >= midDistance) {
                    count++;
                    lastI = i;
                    if (count >= limit) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
