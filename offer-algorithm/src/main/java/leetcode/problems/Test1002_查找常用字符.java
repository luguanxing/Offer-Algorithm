package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1002_查找常用字符 {

    public static void main(String[] args) {
        System.out.println(new Solution().commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(new Solution().commonChars(new String[]{"cool", "lock", "cook"}));
    }

    static class Solution {
        public List<String> commonChars(String[] A) {
            int[] res = new int[26];
            for (int i = 0; i < 26; i++) {
                res[i] = -1;
            }
            for (String word : A) {
                char[] chars = word.toCharArray();
                int[] stat = new int[26];
                for (char c : chars) {
                    stat[c - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    if (res[i] == -1) {
                        res[i] = stat[i];
                    } else if (res[i] > stat[i]) {
                        res[i] = stat[i];
                    }
                }
            }
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (res[i] != 0){
                    for (int j = 0; j < res[i]; j++) {
                        list.add((char) (i + 'a') + "");
                    }
                }
            }
            return list;
        }
    }

}
