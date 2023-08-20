package leetcode.contest.week359;

import java.util.Arrays;
import java.util.List;

public class Test7004_判别首字母缩略词 {

    public static void main(String[] args) {
        System.out.println(new Solution().isAcronym(
                Arrays.asList("alice", "bob", "charlie"), "abc"
        ));
        System.out.println(new Solution().isAcronym(
                Arrays.asList("an", "apple"), "a"
        ));
        System.out.println(new Solution().isAcronym(
                Arrays.asList("never", "gonna", "give", "up", "on", "you"), "ngguoy"
        ));
    }

    static class Solution {
        public boolean isAcronym(List<String> words, String s) {
            String res = "";
            for (String word : words) {
                res += word.charAt(0);
            }
            return res.equals(s);
        }
    }

}
