package leetcode.contest.week315;

public class Test6219_反转之后的数字和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfNumberAndReverse(443));
        System.out.println(new Solution().sumOfNumberAndReverse(63));
        System.out.println(new Solution().sumOfNumberAndReverse(181));
        System.out.println(new Solution().sumOfNumberAndReverse(50));
    }

    static class Solution {
        public boolean sumOfNumberAndReverse(int num) {
            int MAX = Math.min(1000005, num);
            for (int i = 0; i <= MAX; i++) {
                String revereStr = new StringBuilder(Integer.toString(i))
                        .reverse()
                        .toString();
                if (i + Integer.parseInt(revereStr) == num) {
                    return true;
                }
            }
            return false;
        }
    }

}
