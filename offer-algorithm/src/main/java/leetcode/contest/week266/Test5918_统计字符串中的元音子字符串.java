package leetcode.contest.week266;

import java.util.HashSet;
import java.util.Set;

public class Test5918_统计字符串中的元音子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().countVowelSubstrings("aeiouu"));
        System.out.println(new Solution().countVowelSubstrings("unicornarihan"));
        System.out.println(new Solution().countVowelSubstrings("cuaieuouac"));
        System.out.println(new Solution().countVowelSubstrings("bbaeixoubb"));
    }

    static class Solution {
        public int countVowelSubstrings(String word) {
            int res = 0;
            for (int i = 0; i <= word.length(); i++) {
                for (int j = i + 1; j <= word.length(); j++) {
                    String substring = word.substring(i, j);
                    if (substring.contains("a") &&
                            substring.contains("e") &&
                            substring.contains("i") &&
                            substring.contains("o") &&
                            substring.contains("u")) {
                        Set<Character> set = new HashSet<>();
                        for (char c : substring.toCharArray()) {
                            set.add(c);
                        }
                        if (set.size() == 5) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }

}
