package leetcode.contest.week345;

public class Test6431_相邻值的按位异或 {

    public static void main(String[] args) {
        System.out.println(new Solution().doesValidArrayExist(new int[]{1, 1, 0}));
        System.out.println(new Solution().doesValidArrayExist(new int[]{1, 1}));
        System.out.println(new Solution().doesValidArrayExist(new int[]{1, 0}));
    }

    static class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            int len = derived.length;
            for (int start : new int[]{0, 1}) {
                int[] original = new int[len];
                original[0] = start;
                for (int i = 1; i < len; i++) {
                    original[i] = original[i - 1] ^ derived[i - 1];
                }
                if ((original[0] ^ original[len - 1]) == derived[len - 1]) {
                    return true;
                }
            }
            return false;
        }
    }

}
