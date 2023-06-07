package leetcode.problems;

import java.util.Arrays;

public class Test2611_老鼠和奶酪 {

    public static void main(String[] args) {
        System.out.println(new Solution().miceAndCheese(
                new int[]{1, 1, 3, 4},
                new int[]{4, 4, 1, 1},
                2
        ));
        System.out.println(new Solution().miceAndCheese(
                new int[]{1, 1},
                new int[]{1, 1},
                2
        ));
    }

    static class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            // res = a1+a2+...ak + (s2-b1-b2-...bk)
            //     = s2 + (a1-b1) + (a2-b2) + ... (ak-bk)
            int len = reward1.length;
            int s2 = Arrays.stream(reward2).sum();
            int[] diff = new int[len];
            for (int i = 0; i < len; i++) {
                diff[i] = reward1[i] - reward2[i];
            }
            int res = s2;
            Arrays.sort(diff);
            for (int i = len - 1; i > len - 1 - k; i--) {
                res += diff[i];
            }
            return res;
        }
    }

}
