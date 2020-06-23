package leetcode.problems;

import java.math.BigInteger;

public class Test0067_二进制求和 {

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
        System.out.println(new Solution().addBinary("1010", "1011"));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            BigInteger aNum = new BigInteger(a, 2);
            BigInteger bNum = new BigInteger(b, 2);
            return aNum.add(bNum).toString(2);
        }
    }

}
