package leetcode.contest.week273;

import java.util.Arrays;

public class Test5964_执行所有后缀指令 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().executeInstructions(
                3,
                new int[]{0, 1},
                "RRDDLU"
        )));
        System.out.println(Arrays.toString(new Solution().executeInstructions(
                2,
                new int[]{1, 1},
                "LURD"
        )));
        System.out.println(Arrays.toString(new Solution().executeInstructions(
                1,
                new int[]{0, 0},
                "LRUD"
        )));
    }

    static class Solution {
        public int[] executeInstructions(int n, int[] startPos, String s) {
            int[] res = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                res[i] = checkCanMove(n, startPos[0], startPos[1], s, i);
            }
            return res;
        }

        private int checkCanMove(int n, int y, int x, String steps, int stepIndex) {
            int cnt = 0;
            for (int i = stepIndex; i < steps.length(); i++) {
                char c = steps.charAt(i);
                if (c == 'L') {
                    if (x - 1 >= 0) {
                        cnt++;
                        x--;
                    } else {
                        break;
                    }
                } else if (c == 'R') {
                    if (x + 1 < n) {
                        cnt++;
                        x++;
                    } else {
                        break;
                    }
                } else if (c == 'U') {
                    if (y - 1 >= 0) {
                        cnt++;
                        y--;
                    } else {
                        break;
                    }
                } else if (c == 'D') {
                    if (y + 1 < n) {
                        cnt++;
                        y++;
                    } else {
                        break;
                    }
                }
            }
            return cnt;
        }
    }

}
