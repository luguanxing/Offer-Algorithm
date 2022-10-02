package leetcode.contest.week313;

public class Test6194_最小XOR {

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeXor(3, 5));
        System.out.println(new Solution().minimizeXor(1, 12));
        System.out.println(new Solution().minimizeXor(25, 72));
    }

    static class Solution {
        public int minimizeXor(int num1, int num2) {
            int cnt1 = Integer.bitCount(num1);
            int cnt2 = Integer.bitCount(num2);
            if (cnt2 >= cnt1) {
                char[] num1Chars = Integer.toBinaryString(num1).toCharArray();
                int leftCnt = cnt2 - cnt1;
                for (int i = num1Chars.length - 1; i >= 0; i--) {
                    if (leftCnt > 0 && num1Chars[i] == '0') {
                        leftCnt--;
                        num1Chars[i] = '1';
                    }
                }
                String num1Str = new String(num1Chars);
                while (leftCnt > 0) {
                    num1Str = '1' + num1Str;
                    leftCnt--;
                }
                return Integer.parseInt(num1Str, 2);
            } else {
                char[] num1Chars = Integer.toBinaryString(num1).toCharArray();
                int removeCnt = cnt1 - cnt2;
                for (int i = num1Chars.length - 1; i >= 0; i--) {
                    if (removeCnt > 0 && num1Chars[i] == '1') {
                        removeCnt--;
                        num1Chars[i] = '0';
                    }
                }
                return Integer.parseInt(new String(num1Chars), 2);
            }
        }
    }

}
