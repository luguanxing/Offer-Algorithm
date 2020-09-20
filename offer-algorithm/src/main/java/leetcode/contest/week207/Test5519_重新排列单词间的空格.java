package leetcode.contest.week207;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5519_重新排列单词间的空格 {

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("  this   is  a sentence "));
        System.out.println(new Solution().reorderSpaces(" practice   makes   perfect"));
        System.out.println(new Solution().reorderSpaces("hello   world"));
        System.out.println(new Solution().reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(new Solution().reorderSpaces("a"));
    }

    static class Solution {
        public String reorderSpaces(String text) {
            int cnt = 0;
            for (Character c : text.toCharArray()) {
                if (c == ' ') {
                    cnt++;
                }
            }
            List<String> words = Arrays.stream(text.split(" "))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.toList());
            int distance = words.size() == 1 ? 0 : cnt / (words.size() - 1);
            int last = cnt - distance * (words.size() - 1);
            String distanceStr = "";
            String lastStr = "";
            for (int i = 1; i <= distance; i++) {
                distanceStr += ' ';
            }
            for (int i = 1; i <= last; i++) {
                lastStr += ' ';
            }
            return words.stream().collect(Collectors.joining(distanceStr, "", lastStr));
        }
    }

}
