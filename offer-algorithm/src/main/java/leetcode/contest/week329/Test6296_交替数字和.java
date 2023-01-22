package leetcode.contest.week329;

public class Test6296_交替数字和 {

    public static void main(String[] args) {
        System.out.println(new Solution().alternateDigitSum(521));
        System.out.println(new Solution().alternateDigitSum(111));
        System.out.println(new Solution().alternateDigitSum(886996));
    }

    static class Solution {
        public int alternateDigitSum(int n) {
            int sum = 0;
            int flag = 1;
            for (char c : String.valueOf(n).toCharArray()) {
                sum += flag * (c - '0');
                flag *= -1;
            }
            return sum;
        }
    }

}
