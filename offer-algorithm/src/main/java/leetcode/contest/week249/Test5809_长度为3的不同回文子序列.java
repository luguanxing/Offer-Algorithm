package leetcode.contest.week249;

import java.util.*;

public class Test5809_长度为3的不同回文子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution_优化().countPalindromicSubsequence("aabca"));
        System.out.println(new Solution_优化().countPalindromicSubsequence("adc"));
        System.out.println(new Solution_优化().countPalindromicSubsequence("bbcbaba"));
        System.out.println(new Solution_优化().countPalindromicSubsequence("uuuuu"));
        System.out.println(new Solution_优化().countPalindromicSubsequence("tlpjzdmtwderpkpmgoyrcxttiheassztncqvnfjeyxxp"));
    }

    static class Solution_优化 {
        public int countPalindromicSubsequence(String s) {
            int[] left = new int[26];
            int[] right = new int[26];
            for (int i = 0; i < s.length(); i++) {
                right[s.charAt(i) - 'a'] = i;
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                left[s.charAt(i) - 'a'] = i;
            }
            int res = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                Set<Character> set = new HashSet<>();
                for (int i = left[c - 'a'] + 1; i < right[c - 'a']; i++) {
                    set.add(s.charAt(i));
                }
                res += set.size();
            }
            return res;
        }
    }

    static class Solution {
        public int countPalindromicSubsequence(String s) {
            Map<Character, List<Integer>> indexsMap = new HashMap<>();
            Map<Character, Set<Character>> visited = new HashMap<>();
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                List<Integer> list = indexsMap.getOrDefault(c, new ArrayList<>());
                if (!list.isEmpty()) {
                    int current = 0;
                    for (int j = list.get(list.size() - 1) + 1; j < i; j++) {
                        char m = s.charAt(j);
                        Set<Character> set = visited.getOrDefault(c, new HashSet<>());
                        if (!set.contains(m)) {
                            set.add(m);
                            current++;
//                            System.out.println(c + "," + m + "," + c);
                        }
                        visited.put(c, set);
                    }
                    res += current;
                }
                list.add(i);
                indexsMap.put(c, list);
            }
            for (List<Integer> list : indexsMap.values()) {
                if (list.size() > 2) {
                    res++;
                }
            }
            return res;
        }
    }

}
