package leetcode.contest.week218;

public class Test5620_连接连续二进制数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().concatenatedBinary(0));
        System.out.println(new Solution().concatenatedBinary(1));
        System.out.println(new Solution().concatenatedBinary(3));
        System.out.println(new Solution().concatenatedBinary(12));
        System.out.println(new Solution().concatenatedBinary(72387));
        System.out.println(new Solution().concatenatedBinary(67890));
        System.out.println(new Solution().concatenatedBinary(88888));
        System.out.println(new Solution().concatenatedBinary(99999));
        System.out.println(new Solution().concatenatedBinary(100000));
    }

    static class Solution {
        public int concatenatedBinary(int n) {
            StringBuilder str = new StringBuilder();
            Long res = 0l;
            for (int i = 1; i <= n; i++) {
                str.append(Integer.toBinaryString(i));
                res = Long.parseLong(str.toString(), 2);
                res = res % 1000000007;
                str = new StringBuilder(Long.toBinaryString(res));
            }
            return res.intValue();
        }
    }

}
