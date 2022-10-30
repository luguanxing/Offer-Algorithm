package leetcode.contest.week317;

public class Test6220_可被三整除的偶数的平均值 {

    public static void main(String[] args) {
        System.out.println(new Solution().averageValue(new int[]{1, 3, 6, 10, 12, 15}));
        System.out.println(new Solution().averageValue(new int[]{1, 2, 4, 7, 10}));
        System.out.println(new Solution().averageValue(new int[]{4, 4, 9, 10}));
    }

    static class Solution {
        public int averageValue(int[] nums) {
            int sum = 0;
            int cnt = 0;
            for (int num : nums) {
                if (num % 3 == 0 && num % 2 == 0) {
                    sum += num;
                    cnt++;
                }
            }
            return cnt == 0 ? 0 : sum / cnt;
        }
    }

}
