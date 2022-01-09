package leetcode.contest.week275;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test5978_统计追加字母可以获得的单词数 {

    public static void main(String[] args) {
        System.out.println(new Solution().wordCount(
                new String[]{"ant", "act", "tack"},
                new String[]{"tack", "act", "acti"}
        ));
        System.out.println(new Solution().wordCount(
                new String[]{"ab", "a"},
                new String[]{"abc", "abcd"}
        ));
        System.out.println(new Solution().wordCount(
                new String[]{"g", "vf", "ylpuk", "nyf", "gdj", "j", "fyqzg", "sizec"},
                new String[]{"r", "am", "jg", "umhjo", "fov", "lujy", "b", "uz", "y"}
        ));
    }

    static class Solution {
        public int wordCount(String[] startWords, String[] targetWords) {
            // 按字符顺序保留所有startWords
            Set<String> set = new HashSet<>();
            for (String startWord : startWords) {
                char[] chars = startWord.toCharArray();
                Arrays.sort(chars);
                set.add(new String(chars));
            }
            // 按字符顺序将targetWords中拆一个字符，看结果是否出现过
            int res = 0;
            for (String targetWord : targetWords) {
                char[] chars = targetWord.toCharArray();
                Arrays.sort(chars);
                String word = new String(chars);
                for (int i = 0; i < chars.length; i++) {
                    String subWord = word.substring(0, i) + word.substring(i + 1, chars.length);
                    if (set.contains(subWord)) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }

}
