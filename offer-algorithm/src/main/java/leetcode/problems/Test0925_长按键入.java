package leetcode.problems;

public class Test0925_长按键入 {

    public static void main(String[] args) {
        System.out.println(new Solution().isLongPressedName("alex", "aaleex"));
        System.out.println(new Solution().isLongPressedName("saeed", "ssaaedd"));
        System.out.println(new Solution().isLongPressedName("leelee", "lleeelee"));
        System.out.println(new Solution().isLongPressedName("laiden", "laiden"));
        System.out.println(new Solution().isLongPressedName("a", "b"));
        System.out.println(new Solution().isLongPressedName("pyplrz", "ppyypllr"));
        System.out.println(new Solution().isLongPressedName("alex", "alexxr"));
    }

    static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            char[] chars1 = name.toCharArray();
            char[] chars2 = typed.toCharArray();
            int index1 = 0;
            int index2 = 0;
            // 遍历一遍typed字符串
            while (index2 < chars2.length) {
                if (index1 < chars1.length && chars1[index1] == chars2[index2]) {
                    index1++;
                    index2++;
                } else if (index2 > 0 && chars2[index2 - 1] == chars2[index2]) {
                    index2++;
                } else {
                    return false;
                }
            }
            // 判断name字符串是否匹配完
            return index1 == chars1.length;
        }
    }


    static class Solution_未优化 {
        public boolean isLongPressedName(String name, String typed) {
            char[] chars1 = name.toCharArray();
            char[] chars2 = typed.toCharArray();
            int index1 = 0;
            int index2 = 0;
            while (index1 < chars1.length && index2 < chars2.length) {
                char c1 = chars1[index1];
                char c2 = chars2[index2];
                if (c1 == c2) {
                    // 字符匹配上了
                    index1++;
                    index2++;
                    continue;
                }
                if (index2 > 0 && c2 == chars2[index2 - 1]) {
                    // typed的重复字段
                    index2++;
                    continue;
                }
                return false;
            }
            // 确认是否已经匹配完
            if (index1 == chars1.length) {
                for (int i = index2; i < chars2.length && i > 0; i++) {
                    if (chars2[i] != chars2[i - 1]) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

}
