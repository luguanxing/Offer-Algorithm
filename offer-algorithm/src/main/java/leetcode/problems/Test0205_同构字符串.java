package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0205_同构字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("egg", "add"));
        System.out.println(new Solution().isIsomorphic("foo", "bar"));
        System.out.println(new Solution().isIsomorphic("paper", "title"));
        System.out.println(new Solution().isIsomorphic("ab", "ca"));
        System.out.println(new Solution().isIsomorphic("ab", "aa"));
    }

    static class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> map1 = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char si = s.charAt(i);
                char ti = t.charAt(i);
                map1.put(si, ti);
                map2.put(ti, si);
            }
            String mapS = "";
            String mapT = "";
            for (char c : s.toCharArray()) {
                mapS += map1.get(c);
            }
            for (char c : t.toCharArray()) {
                mapT += map2.get(c);
            }
            return mapS.equals(t) && mapT.equals(s);
        }
    }

}
