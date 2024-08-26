package leetcode.contest.week412;

public class Test100394_统计近似相等数对I {

    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[]{3, 12, 30, 17, 21}));
        System.out.println(new Solution().countPairs(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new Solution().countPairs(new int[]{123, 231}));
    }

    static class Solution {
        public int countPairs(int[] nums) {
            int len = nums.length;
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (isApproximateEqual(nums[i], nums[j])) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        private boolean isApproximateEqual(int num1, int num2) {
            if (num1 == num2) {
                return true;
            }
            // 将这个数字中的两个数位交换
            char[] chars1 = Integer.toString(num1).toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                for (int j = i + 1; j < chars1.length; j++) {
                    char temp = chars1[i];
                    chars1[i] = chars1[j];
                    chars1[j] = temp;
                    int num = Integer.parseInt(new String(chars1));
                    if (num == num2) {
                        return true;
                    }
                    temp = chars1[i];
                    chars1[i] = chars1[j];
                    chars1[j] = temp;
                }
            }
            char[] chars2 = Integer.toString(num2).toCharArray();
            for (int i = 0; i < chars2.length; i++) {
                for (int j = i + 1; j < chars2.length; j++) {
                    char temp = chars2[i];
                    chars2[i] = chars2[j];
                    chars2[j] = temp;
                    int num = Integer.parseInt(new String(chars2));
                    if (num == num1) {
                        return true;
                    }
                    temp = chars2[i];
                    chars2[i] = chars2[j];
                    chars2[j] = temp;
                }
            }
            return false;
        }
    }

}
