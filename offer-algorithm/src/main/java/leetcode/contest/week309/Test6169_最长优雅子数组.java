package leetcode.contest.week309;

public class Test6169_最长优雅子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
        System.out.println(new Solution().longestNiceSubarray(new int[]{3, 1, 5, 11, 13}));
        System.out.println(new Solution().longestNiceSubarray(new int[]{536870399, 890391654}));
    }

    static class Solution {
        public int longestNiceSubarray(int[] nums) {
            int len = nums.length;
            // 滑动窗口
            int max = 0;
            int l = 0;
            int r = 0;
            int[] currentState = new int[32];
            while (l <= r && r < len) {
                while (!canAnd(currentState, nums[r])) {
                    removeAnd(currentState, nums[l++]);
                }
                doAnd(currentState, nums[r]);
                r++;
                max = Math.max(max, r - l);
            }
            return max;
        }

        private boolean canAnd(int[] currentState, int num) {
            String str = patch32Str(Integer.toBinaryString(num));
            for (int i = 0; i < 32; i++) {
                if (str.charAt(i) == '1' && currentState[i] == 1) {
                    return false;
                }
            }
            return true;
        }

        private void removeAnd(int[] currentState, int num) {
            String str = patch32Str(Integer.toBinaryString(num));
            for (int i = 0; i < 32; i++) {
                if (str.charAt(i) == '1') {
                    currentState[i] = 0;
                }
            }
        }

        private void doAnd(int[] currentState, int num) {
            String str = patch32Str(Integer.toBinaryString(num));
            for (int i = 0; i < 32; i++) {
                if (str.charAt(i) == '1') {
                    currentState[i] = 1;
                }
            }
        }

        public String patch32Str(String num) {
            while (num.length() < 32) {
                num = '0' + num;
            }
            return num;
        }
    }

}
