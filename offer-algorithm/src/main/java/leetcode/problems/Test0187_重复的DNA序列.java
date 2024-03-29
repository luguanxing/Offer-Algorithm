package leetcode.problems;

import java.util.*;

public class Test0187_重复的DNA序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAAAAAAAA"));
        System.out.println();
        System.out.println(new Solution2().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(new Solution2().findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(new Solution2().findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    static class Solution2 {
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> set = new HashSet<>();
            Set<String> res = new HashSet<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String str = s.substring(i, Math.min(i + 10, s.length()));
                if (set.contains(str)) {
                    res.add(str);
                }
                set.add(str);
            }
            return new ArrayList<>(res);
        }
    }

    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> map = new HashMap<>();
            Set<String> set = new HashSet<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String sub = s.substring(i, Math.min(i + 10, s.length()));
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                if (map.get(sub) > 1) {
                    set.add(sub);
                }
            }
            return new ArrayList<>(set);
        }
    }

}
