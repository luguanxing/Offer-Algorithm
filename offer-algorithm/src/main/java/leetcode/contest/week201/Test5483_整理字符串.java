package leetcode.contest.week201;

import java.util.HashSet;
import java.util.Set;

public class Test5483_整理字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
        System.out.println(new Solution().makeGood("abBAcC"));
        System.out.println(new Solution().makeGood("s"));
    }

    static class Solution {
        public String makeGood(String s) {
            Set<String> set = new HashSet<>();
            for (char c = 'a'; c <= 'z'; c++) {
                set.add(c + "" + (char) (c + 'A' - 'a'));
                set.add((char) (c + 'A' - 'a') + "" + c);
            }
            while (true) {
                boolean noMore = true;
                for (String str : set) {
                    if (s.contains(str)) {
                        noMore = false;
                        s = s.replaceAll(str, "");
                    }
                }
                if (noMore) {
                    break;
                }
            }
            return s;
        }
    }

}
