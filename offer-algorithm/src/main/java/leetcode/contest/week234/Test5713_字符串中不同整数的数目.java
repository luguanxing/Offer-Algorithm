package leetcode.contest.week234;

import java.util.HashSet;
import java.util.Set;

public class Test5713_字符串中不同整数的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(new Solution().numDifferentIntegers("leet1234code234"));
        System.out.println(new Solution().numDifferentIntegers("a1b01c001"));
    }

    static class Solution {
        public int numDifferentIntegers(String word) {
            String str = word;
            for (char c : str.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    str = str.replaceAll(c+"", " ");
                }
            }
            int res = 0;
            Set<String> set = new HashSet<>();
            for (String s : str.split(" ")) {
                if (!s.isEmpty()) {
                    while (s.startsWith("0")) {
                        s = s.substring(1);
                    }
                    if (!set.contains(s)) {
                        res++;
                        set.add(s);
                    }
                }
            }
            return res;
        }
    }

}
