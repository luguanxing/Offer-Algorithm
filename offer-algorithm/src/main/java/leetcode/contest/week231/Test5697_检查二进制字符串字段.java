package leetcode.contest.week231;

public class Test5697_检查二进制字符串字段 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkOnesSegment("1001"));
        System.out.println(new Solution().checkOnesSegment("110"));
        System.out.println(new Solution().checkOnesSegment("1"));
        System.out.println(new Solution().checkOnesSegment("10"));
        System.out.println(new Solution().checkOnesSegment("1000"));
        System.out.println(new Solution().checkOnesSegment("10010"));
    }

    static class Solution {
        public boolean checkOnesSegment(String s) {
            int last = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    if (last != i-1) {
                        return false;
                    } else {
                        last = i;
                    }
                }
            }
            return true;
        }
    }

}
