package leetcode.contest.week292;

public class Test6056_字符串中最大的3位相同数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestGoodInteger("6777133339"));
        System.out.println(new Solution().largestGoodInteger("2300019"));
        System.out.println(new Solution().largestGoodInteger("42352338"));
        System.out.println(new Solution().largestGoodInteger("222"));
    }

    static class Solution {
        public String largestGoodInteger(String num) {
            String res = "";
            for (int i = 0; i <= num.length() - 3; i++) {
                String strNum = num.substring(i, i + 3);
                if (strNum.charAt(0) == strNum.charAt(1) && strNum.charAt(1) == strNum.charAt(2)) {
                    if (strNum.compareTo(res) > 0) {
                        res = strNum;
                    }
                }
            }
            return res;
        }
    }

}
