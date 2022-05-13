package leetcode.interview;

public class Test01_05_一次编辑 {

    public static void main(String[] args) {
        System.out.println(new Solution().oneEditAway("pale", "ple"));
        System.out.println(new Solution().oneEditAway("pales", "pal"));
    }

    static class Solution {
        public boolean oneEditAway(String first, String second) {
            if (first.equals(second)) {
                return true;
            }
            int len1 = first.length();
            int len2 = second.length();
            if (Math.abs(len1 - len2) > 1) {
                return false;
            }

            boolean isOk = false;
            if (len1 == len2) {
                // 是否替换一个字符可以实现
                for (int i = 0; i < len1; i++) {
                    if (first.substring(0, i).equals(second.substring(0, i)) && first.substring(i + 1).equals(second.substring(i + 1))) {
                        isOk = true;
                    }
                }
            } else {
                // 是否删一个字符可以实现
                for (int i = 0; i < len1; i++) {
                    if ((first.substring(0, i) + first.substring(i + 1)).equals(second)) {
                        isOk = true;
                    }
                }
                for (int i = 0; i < len2; i++) {
                    if ((second.substring(0, i) + second.substring(i + 1)).equals(first)) {
                        isOk = true;
                    }
                }
            }
            return isOk;
        }
    }

}
