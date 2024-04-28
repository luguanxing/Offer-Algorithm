package leetcode.contest.week395;

import java.util.ArrayList;
import java.util.List;

public class Test100282_数组最后一个元素的最小值 {

    public static void main(String[] args) {
        System.out.println(new Solution().minEnd(3, 4));
        System.out.println(new Solution().minEnd(2, 7));
        System.out.println(new Solution().minEnd(6715154, 7193485));
        System.out.println(new Solution().minEnd(3, 2));
    }

    static class Solution {
        public long minEnd(int n, int x) {
            // 思路：固定了x的二进制位，从x开始，生成n-1的二进制数字，把他插入x的二进制位的0（不够则往左补）
            String xStr = Integer.toBinaryString(x);
            String nStr = Integer.toBinaryString(n - 1);
            List<Character> list = new ArrayList<>();
            for (char c : xStr.toCharArray()) {
                list.add(c);
            }
            int idx = list.size() - 1;
            for (int i = nStr.length() - 1; i >= 0; i--) {
                char addChar = nStr.charAt(i);
                while (idx >= 0 && list.get(idx) == '1') {
                    idx--;
                }
                if (idx > 0) {
                    list.set(idx, addChar);
                } else {
                    list.add(0, addChar);
                }
                idx--;
            }
            String retBin = list.stream().map(String::valueOf).reduce((a, b) -> a + b).orElse("");
            return Long.parseLong(retBin, 2);
        }
    }


}
