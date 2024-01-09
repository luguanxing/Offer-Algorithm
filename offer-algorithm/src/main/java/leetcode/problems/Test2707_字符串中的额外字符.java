package leetcode.problems;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test2707_字符串中的额外字符 {

    public static void main(String[] args) {
        // s = "leetscode", dictionary = ["leet","code","leetcode"]
        System.out.println(new Solution().minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
        // s = "sayhelloworld", dictionary = ["hello","world"]
        System.out.println(new Solution().minExtraChar("sayhelloworld", new String[]{"hello", "world"}));
        // "rkmsilizktprllwoimafyuqmeqrujxdzgp", ["afy","lyso","ymdt","uqm","cfybt","lwoim","hdzeg","th","rkmsi","d","e","tp","r","jx","tofxe","etjx","llqs","cpir","p","ncz","ofeyx","eqru","l","demij","tjky","jgodm","y","ernt","jfns","akjtl","wt","tk","zg","lxoi","kt"]
        System.out.println(new Solution().minExtraChar("rkmsilizktprllwoimafyuqmeqrujxdzgp", new String[]{"afy", "lyso", "ymdt", "uqm", "cfybt", "lwoim", "hdzeg", "th", "rkmsi", "d", "e", "tp", "r", "jx", "tofxe", "etjx", "llqs", "cpir", "p", "ncz", "ofeyx", "eqru", "l", "demij", "tjky", "jgodm", "y", "ernt", "jfns", "akjtl", "wt", "tk", "zg", "lxoi", "kt"}));
    }

    static class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            Set<String> set = Arrays.stream(dictionary).collect(Collectors.toSet());
            int len = s.length();
            // dp[i] 表示 s前i个字符串 的最小额外字符数, 1 <= i <= len
            // dp[i] = 尝试找min(dp[j]), j < i && s[j, i] in set
            int[] dp = new int[len + 1];
            dp[0] = 0;
            dp[1] = set.contains(s.substring(0, 1)) ? 0 : 1;
            for (int i = 2; i <= len; i++) {
                dp[i] = dp[i - 1] + 1;
                for (int j = 0; j < i; j++) {
                    String suffix = s.substring(j, i);
                    if (set.contains(suffix)) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
            }
            return dp[len];
        }
    }

}
