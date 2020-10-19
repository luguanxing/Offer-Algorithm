package leetcode.problems;


public class Test0844_比较含退格的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new Solution().backspaceCompare("ab##", "c#d#"));
        System.out.println(new Solution().backspaceCompare("a##c", "#a#c"));
        System.out.println(new Solution().backspaceCompare("a#c", "b"));

    }

    static class Solution {
        public boolean backspaceCompare(String S, String T) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (Character c : S.toCharArray()) {
                if (c != '#') {
                    sb1.append(c);
                } else if (sb1.length() > 0) {
                    sb1 = sb1.deleteCharAt(sb1.length() - 1);
                }
            }
            for (Character c : T.toCharArray()) {
                if (c != '#') {
                    sb2.append(c);
                } else if (sb2.length() > 0) {
                    sb2 = sb2.deleteCharAt(sb2.length() - 1);
                }
            }
            return sb1.toString().equals(sb2.toString());
        }
    }

}
