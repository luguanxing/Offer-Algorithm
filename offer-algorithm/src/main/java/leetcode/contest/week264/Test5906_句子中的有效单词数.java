package leetcode.contest.week264;

public class Test5906_句子中的有效单词数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countValidWords("cat and  dog"));
        System.out.println(new Solution().countValidWords("!this  1-s b8d!"));
        System.out.println(new Solution().countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(new Solution().countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
        System.out.println(new Solution().countValidWords("t!his  1-s b8d!"));
        System.out.println(new Solution().countValidWords(" o6 t"));
        System.out.println(new Solution().countValidWords("3x,3!wl"));
        System.out.println(new Solution().countValidWords("o-"));
        System.out.println(new Solution().countValidWords("t.i"));
        System.out.println(new Solution().countValidWords("."));
        System.out.println(new Solution().countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif "));
    }

    static class Solution {
        public int countValidWords(String sentence) {
            while (sentence.contains("  ")) {
                sentence = sentence.replaceAll(" {2}", " ");
            }
            while (sentence.startsWith(" ")) {
                sentence = sentence.substring(1);
            }
            while (sentence.endsWith(" ")) {
                sentence = sentence.substring(0, sentence.length() - 1);
            }
            String[] words = sentence.split(" ");
            int res = 0;
            for (int i = 0; i < words.length; i++) {
                if (isIllegalWord(words[i])) {
                    res++;
                }
            }
            return res;
        }

        private boolean isIllegalWord(String word) {
            // 小写字母
            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    return false;
                }
            }
            // 字符检查
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isDigit(c)) {
                    return false;
                }
                if (!Character.isLowerCase(c) && c != '-' && i != word.length() - 1) {
                    return false;
                }
            }
            // 连字符 '-'
            if (word.startsWith("-") || word.endsWith("-")) {
                return false;
            }
            int cnt = 0;
            for (char c : word.toCharArray()) {
                if (c == '-') {
                    cnt++;
                }
            }
            if (cnt > 1) {
                return false;
            }
            for (int i = 1; i <= word.length() - 1; i++) {
                if (word.charAt(i) == '-' && (!Character.isLowerCase(word.charAt(i - 1)) || !Character.isLowerCase(word.charAt(i + 1)))) {
                    return false;
                }
            }
            return true;
        }
    }

}
