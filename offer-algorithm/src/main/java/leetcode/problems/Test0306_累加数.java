package leetcode.problems;

import java.math.BigInteger;

public class Test0306_累加数 {

    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("112358"));
        System.out.println(new Solution().isAdditiveNumber("199100199"));
        System.out.println(new Solution().isAdditiveNumber("10"));
        System.out.println(new Solution().isAdditiveNumber("1023"));
    }

    static class Solution {
        public boolean isAdditiveNumber(String num) {
            int len = num.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int len1 = i + 1;
                    int len2 = j - i;
                    if (checkFit(num, len1, len2)) {
                        System.out.println(num + "->(" + len1 + "," + (len1+len2) + ")");
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean checkFit(String num, int len1, int len2) {
            String first = num.substring(0, len1);
            if (first.startsWith("0") && first.length() > 1) {
                return false;
            }
            String second = num.substring(len1, len1 + len2);
            if (second.startsWith("0") && second.length() > 1) {
                return false;
            }
            String leftNum = num.substring(len1 + len2);
            if (leftNum.isEmpty()) {
                return false;
            }
            BigInteger last = new BigInteger(second);
            BigInteger next = new BigInteger(first).add(new BigInteger(second));
            while (!leftNum.isEmpty()) {
                if (!leftNum.startsWith(next.toString())) {
                    return false;
                }
                leftNum = leftNum.substring(next.toString().length());
                BigInteger nextNext = last.add(next);
                last = next;
                next = nextNext;
            }
            return true;
        }
    }

}
