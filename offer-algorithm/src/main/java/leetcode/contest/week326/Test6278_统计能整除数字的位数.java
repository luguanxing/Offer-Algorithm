package leetcode.contest.week326;

public class Test6278_统计能整除数字的位数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countDigits(7));
        System.out.println(new Solution().countDigits(121));
        System.out.println(new Solution().countDigits(1248));
    }

    static class Solution {
        public int countDigits(int num) {
            String numStr = Integer.toString(num);
            int res = 0;
            for (char c : numStr.toCharArray()) {
                if (num % (c - '0') == 0) {
                    res++;
                }
            }
            return res;
        }
    }

}
