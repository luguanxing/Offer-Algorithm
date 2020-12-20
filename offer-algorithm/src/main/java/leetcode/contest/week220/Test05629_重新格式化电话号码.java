package leetcode.contest.week220;

public class Test05629_重新格式化电话号码 {

    public static void main(String[] args) {
        System.out.println(new Solution().reformatNumber("1-23-45 6"));
        System.out.println(new Solution().reformatNumber("123 4-567"));
        System.out.println(new Solution().reformatNumber("123 4-5678"));
        System.out.println(new Solution().reformatNumber("12"));
        System.out.println(new Solution().reformatNumber("--17-5 229 35-39475 "));
    }

    static class Solution {
        public String reformatNumber(String number) {
            String numberStr = number.replaceAll(" ", "").replaceAll("-", "");
            String res = "";
            for (int i = 0; i < numberStr.length(); i++) {
                res += numberStr.charAt(i);
                if (i % 3 == 2 && i > 0 && i != numberStr.length() - 1) {
                    res += "-";
                }
            }
            if (numberStr.length() % 3 == 1 && numberStr.length() > 3) {
                res = res.substring(0, res.length() - 3) + "-" + res.charAt(res.length() - 3) + res.charAt(res.length() - 1);
            }
            return res;
        }
    }

}
