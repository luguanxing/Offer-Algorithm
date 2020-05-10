package leetcode.problems;

public class Test0055_跳跃游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Solution().canJump(new int[]{2, 0, 0}));
        System.out.println(new Solution().canJump(new int[]{2, 0}));
        System.out.println(new Solution().canJump(new int[]{0}));
        System.out.println(new Solution().canJump(new int[]{}));
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            if (nums.length == 1) {
                return true;
            }
            // 全不为0肯定能到终点，如果nums[i]为0需要找前面看看有没有nums[j]+j>i即能跳过去的
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    boolean failed = true;
                    for (int j = i - 1; 0 <= j; j--) {
                        if (nums[j] + j > i || (nums[j] + j == i && i == nums.length - 1)) {
                            failed = false;
                            break;
                        }
                    }
                    if (failed) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static class Solution_贪心 {
        public boolean canJump(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            // 标识最远可达范围，并向继续后探索
            int len = nums.length;
            boolean[] reachable = new boolean[len];
            reachable[0] = true;
            int index = 0;
            while (index < len && reachable[index]) {
                int canReach = nums[index];
                for (int i = 1; i <= canReach; i++) {
                    reachable[index + i >= len ? len - 1 : index + i] = true;
                }
                index++;
            }
            return reachable[len - 1];
        }
    }

}
