package leetcode.contest.week263;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5902_检查句子中的数字是否递增 {

    public static void main(String[] args) {
        System.out.println(new Solution().areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(new Solution().areNumbersAscending("hello world 5 x 5"));
        System.out.println(new Solution().areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(new Solution().areNumbersAscending("4 5 11 26"));
    }

    static class Solution {
        public boolean areNumbersAscending(String s) {
            for (char c = 'a'; c <= 'z'; c++) {
                s = s.replaceAll(c + "", " ");
            }
            while (s.contains("  ")) {
                s = s.replaceAll("  ", " ");
            }
            while (s.startsWith(" ")) {
                s = s.substring(1);
            }
            List<Integer> list = Arrays.stream(s.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i-1) >= list.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
