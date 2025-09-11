package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2785_将字符串中的元音字母排序 {

    public static void main(String[] args) {
        System.out.println(new Solution().sortVowels("lEetcOde"));
        System.out.println(new Solution().sortVowels("lYmpH"));
    }

    static class Solution {
        public String sortVowels(String s) {
            int len = s.length();
            List<Integer> charIdxList = new ArrayList<>();
            List<Character> charList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                if (isVowel(c)) {
                    charIdxList.add(i);
                    charList.add(c);
                }
            }
            char[] chars = s.toCharArray();
            Collections.sort(charList);
            for (int i = 0; i < charIdxList.size(); i++) {
                int idx = charIdxList.get(i);
                char c = charList.get(i);
                chars[idx] = c;
            }
            return new String(chars);
        }

        private boolean isVowel(char c) {
            char ch = Character.toLowerCase(c);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
            return false;
        }
    }

}
