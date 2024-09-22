package leetcode.contest.week416;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test100400_举报垃圾信息 {

    public static void main(String[] args) {
        //  message = ["hello","world","leetcode"], bannedWords = ["world","hello"]
        System.out.println(new Solution().reportSpam(new String[]{"hello", "world", "leetcode"}, new String[]{"world", "hello"}));
        // message = ["hello","programming","fun"], bannedWords = ["world","programming","leetcode"]
        System.out.println(new Solution().reportSpam(new String[]{"hello", "programming", "fun"}, new String[]{"world", "programming", "leetcode"}));
    }

    static class Solution {
        public boolean reportSpam(String[] message, String[] bannedWords) {
            int cnt = 0;
            Set<String> set = Arrays.stream(bannedWords).collect(Collectors.toSet());
            for (String word : message) {
                if (set.contains(word)) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                return true;
            } else {
                return false;
            }
        }
    }

}
