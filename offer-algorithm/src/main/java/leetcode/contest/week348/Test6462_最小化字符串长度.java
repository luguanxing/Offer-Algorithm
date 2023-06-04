package leetcode.contest.week348;

public class Test6462_最小化字符串长度 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimizedStringLength("aaabc"));
        System.out.println(new Solution().minimizedStringLength("cbbd"));
        System.out.println(new Solution().minimizedStringLength("dddaaa"));
        System.out.println(new Solution().minimizedStringLength("ipi"));
    }

    static class Solution {
        public int minimizedStringLength(String s) {
            String res = "";
            boolean[] map = new boolean[1000];
            for (char c : s.toCharArray()) {
                if (!map[c]) {
                    map[c] = true;
                    res += c;
                }
            }
            return res.length();
        }
    }

}
