package offer;

public class Test10_变态跳台阶 {

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorII(1));
        System.out.println(new Solution().JumpFloorII(2));
        System.out.println(new Solution().JumpFloorII(3));
        System.out.println(new Solution().JumpFloorII(4));
        System.out.println(new Solution().JumpFloorII(5));
        System.out.println(new Solution().JumpFloorII(6));
    }

    static class Solution {
        public int JumpFloorII(int target) {
            int[] step = new int[target+5];
            step[0] = 1;
            step[1] = 1;
            step[2] = 2;
            for (int stage = 3; stage <= target; stage++) {
                // 走到第stage级台阶仅有n种方式：从stage-1跳1步、从stage-2跳2步、从stage-i跳i步
                for (int i = 0; i < stage; i++) {
                    step[stage] += step[i];
                }
            }
            return step[target];
        }
    }

}
