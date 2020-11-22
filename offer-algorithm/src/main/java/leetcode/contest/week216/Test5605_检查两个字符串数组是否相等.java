package leetcode.contest.week216;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test5605_检查两个字符串数组是否相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().arrayStringsAreEqual(
                new String[]{"ab", "c"},
                new String[]{"a", "bc"}
        ));
        System.out.println(new Solution().arrayStringsAreEqual(
                new String[]{"a", "cb"},
                new String[]{"ab", "c"}
        ));
        System.out.println(new Solution().arrayStringsAreEqual(
                new String[]{"abc", "d", "defg"},
                new String[]{"abcddefg"}
        ));
    }

    static class Solution {
        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            String str1 = Arrays.stream(word1).collect(Collectors.joining());
            String str2 = Arrays.stream(word2).collect(Collectors.joining());
            return str1.equals(str2);
        }
    }

}
