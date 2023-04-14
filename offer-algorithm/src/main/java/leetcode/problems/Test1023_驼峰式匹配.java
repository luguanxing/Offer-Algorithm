package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1023_驼峰式匹配 {

    public static void main(String[] args) {
        System.out.println(new Solution().camelMatch(
                new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FB"
        ));
        System.out.println(new Solution().camelMatch(
                new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FoBa"
        ));
        System.out.println(new Solution().camelMatch(
                new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"},
                "FoBaT"
        ));
        System.out.println(new Solution().camelMatch(
                new String[]{"CompetitiveProgramming", "CounterPick", "ControlPanel"},
                "CooP"
        ));
        System.out.println(new Solution().camelMatch(
                new String[]{"aksvbjLiknuTzqon", "ksvjLimflkpnTzqn", "mmkasvjLiknTxzqn", "ksvjLiurknTzzqbn", "ksvsjLctikgnTzqn", "knzsvzjLiknTszqn"},
                "ksvjLiknTzqn"
        ));
        System.out.println(new Solution().camelMatch(
                new String[]{"uAxaqlzahfialcezsLfj", "cAqlzyahaslccezssLfj", "AqlezahjarflcezshLfj", "AqlzofahaplcejuzsLfj", "tAqlzahavslcezsLwzfj", "AqlzahalcerrzsLpfonj", "AqlzahalceaczdsosLfj", "eAqlzbxahalcezelsLfj"},
                "AqlzahalcezsLfj"
        ));
    }

    static class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> res = new ArrayList<>();
            List<String> patternWords = splitPattern(pattern);
            for (String query : queries) {
                List<String> queryWords = splitPattern(query);
                if (queryWords.size() != patternWords.size()) {
                    res.add(false);
                    continue;
                }
                boolean isMatch = true;
                for (int i = 0; i < queryWords.size(); i++) {
                    String queryWord = queryWords.get(i);
                    String patternWord = patternWords.get(i);
                    if (!canMatch(queryWord, patternWord)) {
                        isMatch = false;
                        break;
                    }
                }
                res.add(isMatch);
            }
            return res;
        }

        private List<String> splitPattern(String pattern) {
            List<String> list = new ArrayList<>();
            for (char c : pattern.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    list.add(c + "");
                } else {
                    if (list.isEmpty()) {
                        continue;
                    }
                    String str = list.get(list.size() - 1);
                    str += c;
                    list.set(list.size() - 1, str);
                }
            }
            return list;
        }

        private boolean canMatch(String queryWord, String patternWord) {
            int len1 = queryWord.length();
            int len2 = patternWord.length();
            int idx1 = 0;
            int idx2 = 0;
            while (idx1 < len1 && idx2 < len2) {
                if (queryWord.charAt(idx1) == patternWord.charAt(idx2)) {
                    idx1++;
                    idx2++;
                } else {
                    idx1++;
                }
            }
            return idx2 == len2;
        }
    }

}
