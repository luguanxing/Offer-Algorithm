package leetcode.problems;

import java.util.*;

public class Test3305_元音辅音字符串计数I {

    public static void main(String[] args) {
        System.out.println(new Solution().countOfSubstrings("aeioqq", 1));
    }

    static class Solution {
        public int countOfSubstrings(String word, int k) {
            char[] chars = word.toCharArray();
            int res = 0;
            for (int i = 0; i < word.length(); i++) {
                for (int j = i; j < word.length(); j++) {
                    int[] map = new int[26];
                    for (int f = i; f <= j; f++) {
                        map[chars[f] - 'a']++;
                    }
                    int cCnt = 0;
                    for (int f = 0; f < 26; f++) {
                        if (f != 'a' - 'a' && f != 'e' - 'a' && f != 'i' - 'a' && f != 'o' - 'a' && f != 'u' - 'a') {
                            cCnt += map[f];
                        }
                    }
                    if (cCnt == k && map['a' - 'a'] > 0 && map['e' - 'a'] > 0 && map['i' - 'a'] > 0 && map['o' - 'a'] > 0 && map['u' - 'a'] > 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

    static class Solution_慢 {
        public int countOfSubstrings(String word, int k) {
            int res = 0;
            for (int i = 0; i < word.length(); i++) {
                for (int j = i + 1; j <= word.length(); j++) {
                    String str = word.substring(i, j);
                    if (ok(str, k)) {
                        System.out.println(str);
                        res++;
                    }
                }
            }
            return res;
        }

        public boolean ok(String str, int k) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }
            }
            return map.values().stream().reduce(Integer::sum).orElse(0) == k && str.contains("a") && str.contains("e") && str.contains("i") && str.contains("o") && str.contains("u");
        }
    }

}
