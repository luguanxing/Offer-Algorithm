package leetcode.problems;

import java.util.*;

public class Test0745_前缀和后缀搜索 {

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"c", "c"});
        System.out.println(wordFilter.f("c", "c"));
    }

    static class WordFilter {
        Map<String, Integer> prefixSuffixMap;

        public WordFilter(String[] words) {
            prefixSuffixMap = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int left = 0; left <= word.length(); left++) {
                    String preifx = word.substring(0, left);
                    for (int right = 0; right <= word.length(); right++) {
                        String suffix = word.substring(right);
                        prefixSuffixMap.put(preifx + "-" + suffix, i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return prefixSuffixMap.getOrDefault(pref + "-" + suff, -1);
        }
    }

    static class WordFilter暴力 {
        String[] words;

        public WordFilter暴力(String[] words) {
            this.words = words;
        }

        public int f(String pref, String suff) {
            for (int i = words.length - 1; i >= 0; i--) {
                if (words[i].startsWith(pref) && words[i].endsWith(suff)) {
                    return i;
                }
            }
            return -1;
        }
    }

}
