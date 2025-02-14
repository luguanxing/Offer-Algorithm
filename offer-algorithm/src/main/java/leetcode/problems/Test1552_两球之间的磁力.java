package leetcode.problems;

import java.util.Arrays;

public class Test1552_两球之间的磁力 {

    public static void main(String[] args) {
        // position = [1,2,3,4,7], m = 3
        System.out.println(new Solution().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        // position = [5,4,3,2,1,1000000000], m = 2
        System.out.println(new Solution().maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
    }

    static class Solution {
        public int maxDistance(int[] position, int m) {
            // 使用二分试出间隔的最大值
            Arrays.sort(position);
            int l = 1;
            int r = (int) 1e9;
            while (l < r) {
                int d = l + (r - l) / 2;
                // 获取间隔为d时能获得的数量
                int cnt = checkCnt(position, d);
                if (cnt < m) {
                    // 数量太少，说明间隔太大，需要缩小间隔
                    r = d;
                } else {
                    // 数量太多，说明间隔太小，需要增大间隔
                    l = d + 1;
                }
            }
            return l - 1;
        }

        private int checkCnt(int[] position, int d) {
            int cnt = 1;
            int current = position[0];
            for (int pos : position) {
                if (pos - current >= d) {
                    cnt++;
                    current = pos;
                }
            }
            return cnt;
        }
    }

}
