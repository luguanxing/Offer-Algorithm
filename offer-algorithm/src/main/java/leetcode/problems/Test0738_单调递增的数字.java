package leetcode.problems;

public class Test0738_单调递增的数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().monotoneIncreasingDigits(10));
        System.out.println(new Solution().monotoneIncreasingDigits(1234));
        System.out.println(new Solution().monotoneIncreasingDigits(332));
    }

    static class Solution {
        public int monotoneIncreasingDigits(int N) {
            // 从右向左，如果比左边小则右边全部变为9
            String str = Integer.toString(N);
            char[] chars = str.toCharArray();
            for (int i = chars.length - 1; i >= 1; i--) {
                if (chars[i - 1] > chars[i]) {
                    chars[i - 1]--;
                    for (int j = i; j < chars.length; j++) {
                        chars[j] = '9';
                    }
                }
            }
            return Integer.parseInt(new String(chars));
        }
    }

}
