package leetcode.problems;

public class Test0476_数字的补数 {

    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(5));
        System.out.println(new Solution().findComplement(1));
    }

    static class Solution {
        public int findComplement(int num) {
            String str = Integer.toBinaryString(num);
            String res = "";
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    res += "0";
                } else if (c == '0') {
                    res += "1";
                }
            }
            return Integer.parseInt(res, 2);
        }
    }

}
