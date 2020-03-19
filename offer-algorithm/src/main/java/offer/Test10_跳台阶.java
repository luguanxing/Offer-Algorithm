package offer;

public class Test10_跳台阶 {

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloor(1));
        System.out.println(new Solution().JumpFloor(2));
        System.out.println(new Solution().JumpFloor(3));
        System.out.println(new Solution().JumpFloor(4));
        System.out.println(new Solution().JumpFloor(5));
    }

    static class Solution {
        public int JumpFloor(int target) {
            int[] step = new int[target+5];
            step[1] = 1;
            step[2] = 2;
            for (int stage = 3; stage <= target; stage++) {
                // 走到第stage级台阶仅有两种方式：从stage-1跳1步、从stage-2跳2步
                step[stage] = step[stage - 1] + step[stage - 2];
            }
            return step[target];
        }
    }

}
