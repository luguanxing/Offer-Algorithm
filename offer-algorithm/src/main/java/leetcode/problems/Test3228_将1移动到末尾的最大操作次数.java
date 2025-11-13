package leetcode.problems;

public class Test3228_将1移动到末尾的最大操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxOperations("1001101"));
        System.out.println(new Solution().maxOperations("00111"));
    }

    static class Solution {
        public int maxOperations(String s) {
            // 从右向左统计每批1右边0的批数量
            char[] chars = s.toCharArray();
            int len = s.length();
            int group0Cnt = 0;
            int res = 0;
            char last = chars[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                char c = chars[i];
                if (c == '1' && last == '0') {
                    group0Cnt++;
                }
                if (c == '1') {
                    res += group0Cnt;
                }
                last = c;
            }
            return res;
        }
    }

}
