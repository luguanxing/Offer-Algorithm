package leetcode.contest.week355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6921_按分隔符拆分字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().splitWordsBySeparator(
                Arrays.asList("one.two.three","four.five","six"),
                '.'
        ));
        System.out.println(new Solution().splitWordsBySeparator(
                Arrays.asList("$easy$","$problem$"),
                '$'
        ));
        System.out.println(new Solution().splitWordsBySeparator(
                Arrays.asList("|||"),
                '|'
        ));
    }

    static class Solution {
        public List<String> splitWordsBySeparator(List<String> words, char separator) {
            List<String> result = new ArrayList<>();
            String separatorStr = separator + "";
            for (String word : words) {
                String[] splitWords = word.split("\\Q" + separatorStr + "\\E");
                for (String splitWord : splitWords) {
                    if (!splitWord.isEmpty()) {
                        result.add(splitWord);
                    }
                }
            }
            return result;
        }
    }

}
