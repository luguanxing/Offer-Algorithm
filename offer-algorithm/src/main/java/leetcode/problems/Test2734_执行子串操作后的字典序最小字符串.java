package leetcode.problems;

public class Test2734_执行子串操作后的字典序最小字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestString("cbabc"));
        System.out.println(new Solution().smallestString("acbbc"));
        System.out.println(new Solution().smallestString("leetcode"));
        System.out.println(new Solution().smallestString("aa"));
        System.out.println(new Solution().smallestString("a"));
        System.out.println(new Solution().smallestString("aax"));
        System.out.println(new Solution().smallestString("aaxx"));
        System.out.println(new Solution().smallestString("aaxxa"));
    }

    static class Solution {
        public String smallestString(String s) {
            int len = s.length();
            char[] chars = s.toCharArray();
            int a1 = s.indexOf('a');
            // 没有a，全部减小
            if (a1 < 0) {
                for (int i = 0; i < len; i++) {
                    chars[i]--;
                }
                return new String(chars);
            }
            // 有a时，要分位置处理
            if (a1 > 0) {
                // 有a不为但首位，只转换a的前部分
                for (int i = 0; i < a1; i++) {
                    chars[i]--;
                }
            } else {
                // a已是首位，找下一位a或末尾，只转换中间部分的字符
                int a2 = a1;
                while (a2 < len - 1) {
                    // 起点从当前的a1之后连续的尽头a开始，设为a2
                    if (chars[a2] == 'a') {
                        a2++;
                    } else {
                        break;
                    }
                }
                // 下一位a或尽头，设为a3
                int a3 = s.indexOf('a', a2 + 1);
                if (a3 < 0) {
                    a3 = len;
                }
                for (int i = a2; i < a3; i++) {
                    chars[i]--;
                }
            }
            // 处理小于'a'的字符
            for (int i = 0; i < len; i++) {
                if (chars[i] < 'a') {
                    chars[i] = 'z';
                }
            }
            return new String(chars);
        }
    }

}
