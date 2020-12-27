package leetcode.contest.week221;

public class Test5637_判断字符串的两半是否相似 {

    public static void main(String[] args) {
        System.out.println(new Solution().halvesAreAlike("book"));
        System.out.println(new Solution().halvesAreAlike("textbook"));
        System.out.println(new Solution().halvesAreAlike("MerryChristmas"));
        System.out.println(new Solution().halvesAreAlike("AbCdEfGh"));
    }

    static class Solution {
        public boolean halvesAreAlike(String s) {
            int a = 0;
            int b = 0;
            s = s.toLowerCase();
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                    a++;
                }
            }
            for (int i = s.length() / 2; i < s.length(); i++) {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                    b++;
                }
            }
            return a == b;
        }
    }

}
