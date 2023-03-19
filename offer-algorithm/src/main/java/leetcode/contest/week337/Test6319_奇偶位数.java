package leetcode.contest.week337;

import java.util.Arrays;

public class Test6319_奇偶位数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().evenOddBit(17)));
        System.out.println(Arrays.toString(new Solution().evenOddBit(2)));
    }

    static class Solution {
        public int[] evenOddBit(int n) {
            String str = Integer.toBinaryString(n);
            int even = 0;
            int odd = 0;
            int idx = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                if (str.charAt(i) == '1') {
                    if (idx % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }
                idx++;
            }
            return new int[]{even, odd};
        }
    }

}
