package leetcode.problems;

public class Test1247_交换字符使得字符串相同 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSwap("xx", "yy"));
        System.out.println(new Solution().minimumSwap("xy", "yx"));
        System.out.println(new Solution().minimumSwap("xx", "xy"));
        System.out.println(new Solution().minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }

    static class Solution {
        public int minimumSwap(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return -1;
            }
            // 统计xy和yx的对数
            int xy = 0;
            int yx = 0;
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 == c2) {
                    continue;
                }
                if (c1 == 'x' && c2 == 'y') {
                    xy++;
                }
                if (c1 == 'y' && c2 == 'x') {
                    yx++;
                }
            }
            // 一次交换可减少2组xy对或yx对
            // 两次交换可减少1组xy对和yx对
            if ((xy + yx) % 2 != 0) {
                return -1;
            }
            // 先尽量一次减少2组，再两次减少各1组
            return (xy / 2 + yx / 2) + (xy % 2 + yx % 2);
        }
    }

}
