package leetcode.contest.week345;

import java.util.Arrays;

public class Test6430_找出转圈游戏输家 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().circularGameLosers(5, 2)));
        System.out.println(Arrays.toString(new Solution().circularGameLosers(4, 4)));
        System.out.println(Arrays.toString(new Solution().circularGameLosers(5, 4)));
    }

    static class Solution {
        public int[] circularGameLosers(int n, int k) {
            boolean[] map = new boolean[n];
            int cur = 0;
            for (int i = 1; ; i++) {
                if (map[cur]) {
                    break;
                }
                map[cur] = true;
                cur += i * k;
                cur %= n;
            }
            int left = 0;
            for (int i = 0; i < n; i++) {
                if (!map[i]) {
                    left++;
                }
            }
            int[] res = new int[left];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (!map[i]) {
                    res[idx++] = i+1;
                }
            }
            return res;
        }
    }

}
