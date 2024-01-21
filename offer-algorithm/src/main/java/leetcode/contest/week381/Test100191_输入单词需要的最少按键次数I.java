package leetcode.contest.week381;

public class Test100191_输入单词需要的最少按键次数I {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPushes("abcde"));
        System.out.println(new Solution().minimumPushes("xycdefghij"));
    }

    static class Solution {
        public int minimumPushes(String word) {
            int len = word.length();
            if (len <= 8) {
                return len;
            } else if (len <= 16) {
                return (len - 8) * 2 + 8;
            } else if (len <= 24) {
                return 8 + 16 + (len - 16) * 3;
            } else {
                return 8 + 16 + 24 + (len - 24) * 4;
            }
        }
    }

}
