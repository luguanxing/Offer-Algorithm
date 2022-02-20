package leetcode.contest.week281;

public class Test6012_统计各位数字之和为偶数的整数个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countEven(4));
        System.out.println(new Solution().countEven(30));
    }

    static class Solution {
        public int countEven(int num) {
            int res = 0;
            for (int i = 1; i <= num; i++) {
                int sum = 0;
                for (char c : String.valueOf(i).toCharArray()) {
                    sum += c - '0';
                }
                if (sum % 2 == 0) {
                    res++;
                }
            }
            return res;
        }
    }

}
