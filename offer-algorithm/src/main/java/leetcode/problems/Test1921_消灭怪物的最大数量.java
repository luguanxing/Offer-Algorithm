package leetcode.problems;

import java.util.Arrays;

public class Test1921_消灭怪物的最大数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().eliminateMaximum(
                new int[]{1, 3, 4},
                new int[]{1, 1, 1}
        ));
        System.out.println(new Solution().eliminateMaximum(
                new int[]{1, 1, 2, 3},
                new int[]{1, 1, 1, 1}
        ));
        System.out.println(new Solution().eliminateMaximum(
                new int[]{3, 2, 4},
                new int[]{5, 3, 2}
        ));
    }

    static class Solution {
        public int eliminateMaximum(int[] dist, int[] speed) {
            int len = dist.length;
            int[] arriveTime = new int[len];
            for (int i = 0; i < len; i++) {
                arriveTime[i] = dist[i] / speed[i];
                if (dist[i] % speed[i] != 0) {
                    arriveTime[i]++;
                }
            }
            Arrays.sort(arriveTime);
            int cnt = 0;
            for (int t = 1; t <= len; t++) {
                if (t <= arriveTime[t - 1]) {
                    cnt++;
                } else {
                    break;
                }
            }
            return cnt;
        }
    }

}
