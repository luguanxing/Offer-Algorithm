package leetcode.problems;

import java.util.Arrays;

public class Test0717_1比特与2比特字符 {

    public static void main(String[] args) {
        System.out.println(new Solution_优化().isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(new Solution_优化().isOneBitCharacter(new int[]{1, 1, 1, 0}));
        System.out.println(new Solution_优化().isOneBitCharacter(new int[]{1, 1, 0}));
        System.out.println(new Solution_优化().isOneBitCharacter(new int[]{1, 1, 1, 1, 0}));
    }

    static class Solution {
        public boolean isOneBitCharacter(int[] bits) {
            // 只需判断是否能构成前N-1位
            int[] prefix = Arrays.copyOfRange(bits, 0, bits.length - 1);
            String str = "";
            for (Integer bit : prefix) {
                str += bit;
            }
            while (str.length() > 1) {
                if (str.startsWith("10") || str.startsWith("11")) {
                    str = str.substring(2);
                } else if (str.startsWith("0")) {
                    str = str.substring(1);
                }
            }
            return str.isEmpty() || str.equals("0");
        }
    }

    static class Solution_优化 {
        public boolean isOneBitCharacter(int[] bits) {
            // 1走2位，0走1位，看能否走到最后一位之前
            int index = 0;
            while (index < bits.length) {
                if (index == bits.length - 1) {
                    return true;
                }
                if (bits[index] == 1) {
                    index += 2;
                } else {
                    index += 1;
                }
            }
            return false;
        }
    }

}
