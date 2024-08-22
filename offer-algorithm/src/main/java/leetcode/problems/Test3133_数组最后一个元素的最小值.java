package leetcode.problems;

import java.util.Arrays;

public class Test3133_数组最后一个元素的最小值 {

    public static void main(String[] args) {
        System.out.println(new Solution().minEnd(3, 4));
        System.out.println(new Solution().minEnd(2, 7));
        System.out.println(new Solution().minEnd(3, 7));
    }

    static class Solution {
        public long minEnd(int n, int x) {
            // 将固定的x二进制1从右到左的0 补上 n-1的二进制
            String xBinary = Integer.toBinaryString(x);
            String nBinary = Integer.toBinaryString(n);
            int xLen = xBinary.length();
            int nLen = nBinary.length();
            char[] resBinary = new char[xLen + nLen];
            Arrays.fill(resBinary, '0');
            for (int i = 0; i < xLen; i++) {
                resBinary[nLen + i] = xBinary.charAt(i);
            }
            String n1Binary = Integer.toBinaryString(n - 1);
            int n1Len = n1Binary.length();
            int idx = resBinary.length - 1;
            for (int i = n1Len - 1; i >= 0; i--) {
                char n1b = n1Binary.charAt(i);
                while (resBinary[idx] == '1') {
                    idx--;
                }
                resBinary[idx--] = n1b;
            }
            return Long.parseLong(new String(resBinary), 2);
        }
    }

}
