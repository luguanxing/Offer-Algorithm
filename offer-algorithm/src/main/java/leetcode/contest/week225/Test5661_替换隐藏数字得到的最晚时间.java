package leetcode.contest.week225;

public class Test5661_替换隐藏数字得到的最晚时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTime("2?:?0"));
        System.out.println(new Solution().maximumTime("0?:3?"));
        System.out.println(new Solution().maximumTime("1?:22"));
        System.out.println(new Solution().maximumTime("?4:03"));
        System.out.println(new Solution().maximumTime("14:?3"));
        System.out.println(new Solution().maximumTime("14:?0"));
        System.out.println(new Solution().maximumTime("??:3?"));
        System.out.println(new Solution().maximumTime("??:??"));
        System.out.println(new Solution().maximumTime("?6:??"));
        System.out.println(new Solution().maximumTime("?1:??"));
        System.out.println(new Solution().maximumTime("?3:02"));
    }

    static class Solution {
        public String maximumTime(String time) {
            char[] chars = time.toCharArray();
            if (chars[0] == '?') {
                if (chars[1] < '4' || chars[1] == '?') {
                    chars[0] = '2';
                } else {
                    chars[0] = '1';
                }
            }
            if (chars[1] == '?') {
                if (chars[0] == '0' || chars[0] == '1') {
                    chars[1] = '9';
                } else {
                    chars[1] = '3';
                }
            }
            if (chars[3] == '?') {
                chars[3] = '5';
            }
            if (chars[4] == '?') {
                chars[4] = '9';
            }
            return new String(chars);
        }
    }

}
