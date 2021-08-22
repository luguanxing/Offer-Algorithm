package leetcode.problems;

public class Test0789_逃脱阻碍者 {

    public static void main(String[] args) {
        System.out.println(new Solution().escapeGhosts(
                new int[][]{{1, 0}, {0, 3}},
                new int[]{0, 1}
        ));
        System.out.println(new Solution().escapeGhosts(
                new int[][]{{1, 0}},
                new int[]{2, 0}
        ));
    }

    static class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            int steps = Math.abs(target[0]) + Math.abs(target[1]);
            // 阻碍者能先到则失败
            for (int[] ghost : ghosts) {
                int ghostSteps = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
                if (ghostSteps <= steps) {
                    return false;
                }
            }
            return true;
        }
    }

}
