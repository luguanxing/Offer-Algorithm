package leetcode.contest.week201;

public class Test5484_找出第N个二进制字符串中的第K位 {

    public static void main(String[] args) {
        System.out.println(new Solution().findKthBit(3, 1));
        System.out.println(new Solution().findKthBit(4, 11));
        System.out.println(new Solution().findKthBit(1, 1));
    }

    static class Solution {
        public char findKthBit(int n, int k) {
            String s = "0";
            for (int i = 1; i < n; i++) {
                String s2 = s;
                s2 = s2.replaceAll("0", "A");
                s2 = s2.replaceAll("1", "0");
                s2 = s2.replaceAll("A", "1");
                s += "1" + new StringBuilder(s2).reverse();
            }
            return s.charAt(k -1);
        }
    }

}
