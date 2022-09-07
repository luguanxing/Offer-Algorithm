package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1592_重新排列单词间的空格 {

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces("  this   is  a sentence "));
        System.out.println(new Solution().reorderSpaces(" practice   makes   perfect"));
        System.out.println(new Solution().reorderSpaces("hello   world"));
        System.out.println(new Solution().reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(new Solution().reorderSpaces("a"));
        System.out.println(new Solution().reorderSpaces("  hello"));
    }

    static class Solution {
        public String reorderSpaces(String text) {
            List<String> words = new ArrayList<>();
            int cnt = 0;
            for (String word : text.split(" ")) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            for (char c : text.toCharArray()) {
                if (c == ' ') {
                    cnt++;
                }
            }
            int intervalCnt = 0;
            int intervalLeft = 0;
            if (words.size() != 1) {
                intervalCnt = cnt / (words.size() - 1);
                intervalLeft = cnt % (words.size() - 1);
            } else {
                intervalLeft = cnt;
            }
            String res = "";
            res += words.get(0);
            for (int i = 1; i < words.size(); i++) {
                for (int j = 1; j <= intervalCnt; j++) {
                    res += " ";
                }
                res += words.get(i);
            }
            for (int j = 1; j <= intervalLeft; j++) {
                res += " ";
            }
            return res;
        }
    }

}
