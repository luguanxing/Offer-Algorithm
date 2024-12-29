package leetcode.contest.week430;

public class Test100508_从盒子中找出字典序最大的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().answerString("dbca", 2));
        System.out.println(new Solution().answerString("gggg", 4));
        System.out.println(new Solution().answerString("aann", 2));
        System.out.println(new Solution().answerString("gh", 1));
    }

    static class Solution {
        public String answerString(String word, int numFriends) {
            int len = word.length();
            if (numFriends == 1) {
                return word;
            }
            int wordLen = len - numFriends + 1;
            String maxStr = null;
            for (int i = wordLen; i <= len + wordLen; i++) {
                String currentStr = word.substring(i-wordLen, Math.min(i, len));
                if (maxStr == null || currentStr.compareTo(maxStr) > 0) {
                    maxStr = currentStr;
                }
            }
            return maxStr;
        }
    }

}
