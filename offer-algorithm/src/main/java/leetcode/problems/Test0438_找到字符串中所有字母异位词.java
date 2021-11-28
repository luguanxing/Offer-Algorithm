package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0438_找到字符串中所有字母异位词 {

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution().findAnagrams("abab", "ab"));
        System.out.println(new Solution().findAnagrams("aaaaaaaaaa", "aaaaaaaaaaaaa"));
    }

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] pMap = new int[26];
            for (char c : p.toCharArray()) {
                pMap[c - 'a']++;
            }
            List<Integer> res = new ArrayList<>();
            int pLen = p.length();
            int sLen = s.length();
            int[] sMap = new int[26];
            for (int i = 0; i < Math.min(pLen, sLen); i++) {
                sMap[s.charAt(i) - 'a']++;
            }
            for (int i = pLen; i <= sLen; i++) {
                if (Arrays.toString(pMap).equals(Arrays.toString(sMap))) {
                    res.add(i - pLen);
                }
                if (i == sLen) {
                    break;
                }
                sMap[s.charAt(i - pLen) - 'a']--;
                sMap[s.charAt(i) - 'a']++;
            }
            return res;
        }
    }

}
