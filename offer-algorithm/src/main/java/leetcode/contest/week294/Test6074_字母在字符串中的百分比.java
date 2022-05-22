package leetcode.contest.week294;

public class Test6074_字母在字符串中的百分比 {

    public static void main(String[] args) {
        System.out.println(new Solution().percentageLetter("foobar", 'o'));
        System.out.println(new Solution().percentageLetter("jjjj", 'k'));
    }

    static class Solution {
        public int percentageLetter(String s, char letter) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == letter) {
                    cnt++;
                }
            }
            return cnt * 100 / s.length();
        }
    }

}
