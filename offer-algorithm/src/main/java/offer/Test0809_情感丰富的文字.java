package offer;

import java.util.ArrayList;
import java.util.List;

public class Test0809_情感丰富的文字 {

    public static void main(String[] args) {
        System.out.println(new Solution().expressiveWords(
                "heeellooo",
                new String[]{"hello", "hi", "helo"}
        ));
        System.out.println(new Solution().expressiveWords(
                "dddiiiinnssssssoooo",
                new String[]{"dinnssoo", "ddinso", "ddiinnso", "ddiinnssoo", "ddiinso", "dinsoo", "ddiinsso", "dinssoo", "dinso"}
        ));
        System.out.println(new Solution().expressiveWords(
                "aaa",
                new String[]{"aaaa"}
        ));
        System.out.println(new Solution().expressiveWords(
                "heeelllooo",
                new String[]{"hellllo"}
        ));
    }

    static class Solution {
        public int expressiveWords(String s, String[] words) {
            int res = 0;
            for (String word : words) {
                if (canExtend(word, s)) {
                    res++;
                }
            }
            return res;
        }

        private boolean canExtend(String from, String to) {
            List<CharCnt> fromList = getList(from);
            List<CharCnt> toList = getList(to);
            if (fromList.size() != toList.size()) {
                return false;
            }
            for (int i = 0; i < fromList.size(); i++) {
                CharCnt fcc = fromList.get(i);
                CharCnt tcc = toList.get(i);
                if (fcc.n > tcc.n) {
                    return false;
                }
                if (fcc.c != tcc.c) {
                    return false;
                }
                if (fcc.n == tcc.n) {
                    continue;
                }
                if (tcc.n < 3) {
                    return false;
                }
            }
            return true;
        }

        private List<CharCnt> getList(String s) {
            List<CharCnt> list = new ArrayList<>();
            char lastChar = ' ';
            int lastCnt = 0;
            for (char c : s.toCharArray()) {
                if (c == lastChar) {
                    lastCnt++;
                } else {
                    list.add(new CharCnt(lastChar, lastCnt));
                    lastChar = c;
                    lastCnt = 1;
                }
            }
            list.add(new CharCnt(lastChar, lastCnt));
            list.remove(0);
            return list;
        }


        class CharCnt {
            char c;
            int n;

            public CharCnt(char c, int n) {
                this.c = c;
                this.n = n;
            }
        }
    }

}
