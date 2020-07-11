package leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test17_13_恢复空格 {

    public static void main(String[] args) {
        System.out.println(new Solution().respace(
                new String[]{
                        "van", "darkholme"
                },
                "mynameisvandarkholmehaha"
        ));
        System.out.println(new Solution().respace(
                new String[]{
                        "looked", "just", "like", "her", "brother"
                },
                "jesslookedjustliketimherbrother"
        ));
        System.out.println(new Solution().respace(
                new String[]{
                        "looked", "just", "like", "her", "brother"
                },
                ""
        ));
    }

    static class Solution {
        public int respace(String[] dictionary, String sentence) {
            if (sentence == null || sentence.isEmpty()) {
                return 0;
            }
            // dp[i]表示长度i所含最未识别字符，前闭后开数组长度需要加一
            // dp[i] = min(dp[0-k) && sentence[k-i) in dictionary)
            int[] dp = new int[sentence.length() + 1];
            Set<String> list = Arrays.stream(dictionary).collect(Collectors.toSet());
            dp[1] = list.contains(sentence.charAt(0) + "") ? 0 : 1;
            for (int i = 2; i <= sentence.length(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    String suffix = sentence.substring(j, i);
                    if (list.contains(suffix)) {
                        min = Math.min(min, dp[j]);
                    } else {
                        min = Math.min(min, i - j + dp[j]);
                    }
                }
                dp[i] = min;
            }
            return dp[sentence.length()];
        }
    }

    static class Solution_TLE {
        private List<Integer> wordLenList = new ArrayList<>();

        public int respace(String[] dictionary, String sentence) {
            // 递归匹配单词
            match(dictionary, sentence);
            return wordLenList.stream().min(Integer::compareTo).orElse(0);
        }

        public void match(String[] dictionary, String sentence) {
            for (String word : dictionary) {
                if (sentence.contains(word)) {
                    int wordIndex = sentence.indexOf(word);
                    String newSentence = sentence.substring(0, wordIndex) + sentence.substring(wordIndex + word.length());
                    match(dictionary, newSentence);
                }
            }
            wordLenList.add(sentence.length());
        }
    }

}
