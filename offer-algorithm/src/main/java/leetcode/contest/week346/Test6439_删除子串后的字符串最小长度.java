package leetcode.contest.week346;

public class Test6439_删除子串后的字符串最小长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().minLength("ABFCACDB"));
        System.out.println(new Solution().minLength("ACBBD"));
    }

    static class Solution {
        public int minLength(String s) {
            while (s.contains("AB") || s.contains("CD")) {
                s = s.replaceAll("AB", "");
                s = s.replaceAll("CD", "");
            }
            return s.length();
        }
    }

}
