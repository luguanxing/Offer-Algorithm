package leetcode.problems;

public class Test0038_外观数列 {

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(1));
        System.out.println(new Solution().countAndSay(2));
        System.out.println(new Solution().countAndSay(3));
        System.out.println(new Solution().countAndSay(4));
        System.out.println(new Solution().countAndSay(5));
    }

    static class Solution {
        public String countAndSay(int n) {
            String res = "";
            for (int i = 1; i <= n; i++) {
                res = getStr(res);
            }
            return res;
        }

        public String getStr(String str) {
            if (str.isEmpty()) {
                return "1";
            }
            String res = "";
            char cur = str.charAt(0);
            int cnt = 1;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == cur) {
                    cnt++;
                } else {
                    res += cnt + "" + cur;
                    cnt = 1;
                    cur = str.charAt(i);
                }
            }
            res += cnt + "" + cur;
            return res;
        }
    }

}
