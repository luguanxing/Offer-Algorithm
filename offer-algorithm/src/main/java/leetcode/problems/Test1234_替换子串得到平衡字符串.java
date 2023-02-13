package leetcode.problems;

public class Test1234_替换子串得到平衡字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().balancedString("QWER"));
        System.out.println(new Solution().balancedString("QQWE"));
        System.out.println(new Solution().balancedString("QQQW"));
        System.out.println(new Solution().balancedString("QQQQ"));
    }

    static class Solution {
        public int balancedString(String s) {
            int len = s.length();
            int avg = len / 4;
            int[] qwer = new int[4];
            for (char c : s.toCharArray()) {
                if (c == 'Q') {
                    qwer[0]++;
                } else if (c == 'W') {
                    qwer[1]++;
                } else if (c == 'E') {
                    qwer[2]++;
                } else if (c == 'R') {
                    qwer[3]++;
                }
            }
            if (qwer[0] == avg && qwer[1] == avg && qwer[2] == avg && qwer[3] == avg) {
                return 0;
            }
            // 使用滑动窗口，算出让qwer个数均小于avg时的最小r-l
            int minWindowSize = s.length();
            int left = 0;
            int right = 0;
            while (left < len) {
                if (right < len) {
                    char c = s.charAt(right++);
                    if (c == 'Q') {
                        qwer[0]--;
                    } else if (c == 'W') {
                        qwer[1]--;
                    } else if (c == 'E') {
                        qwer[2]--;
                    } else if (c == 'R') {
                        qwer[3]--;
                    }
                }
                while (left < right && qwer[0] <= avg && qwer[1] <= avg && qwer[2] <= avg && qwer[3] <= avg) {
                    minWindowSize = Math.min(minWindowSize, right - left);
                    char c = s.charAt(left++);
                    if (c == 'Q') {
                        qwer[0]++;
                    } else if (c == 'W') {
                        qwer[1]++;
                    } else if (c == 'E') {
                        qwer[2]++;
                    } else if (c == 'R') {
                        qwer[3]++;
                    }
                }
                if (right == len) {
                    left++;
                }
            }
            return minWindowSize;
        }

    }

}
