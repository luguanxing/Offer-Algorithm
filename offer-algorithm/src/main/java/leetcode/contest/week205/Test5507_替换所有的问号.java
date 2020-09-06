package leetcode.contest.week205;

public class Test5507_替换所有的问号 {

    public static void main(String[] args) {
        System.out.println(new Solution().modifyString("?zs"));
        System.out.println(new Solution().modifyString("ubv?w"));
        System.out.println(new Solution().modifyString("j?qg??b"));
        System.out.println(new Solution().modifyString("??yw?ipkj?"));
    }

    static class Solution {
        public String modifyString(String s) {
            char[] chars = s.toCharArray();
            if (chars[0] == '?') {
                if (chars.length == 1) {
                    chars[0] = 'a';
                    return new String(chars);
                } else {
                    for (int i = 0; i < 26; i++) {
                        if ('a' + i != chars[1]) {
                            chars[0] = (char) ('a' + i);
                            break;
                        }
                    }
                }
            }
            for (int i = 1; i < chars.length - 1; i++) {
                if (chars[i] == '?') {
                    for (int j = 0; j < 26; j++) {
                        if ('a' + j != chars[i - 1] && 'a' + j != chars[i + 1]) {
                            chars[i] = (char) ('a' + j);
                            break;
                        }
                    }
                }
            }
            if (chars[chars.length - 1] == '?') {
                for (int i = 0; i < 26; i++) {
                    if ('a' + i != chars[chars.length - 2]) {
                        chars[chars.length - 1] = (char) ('a' + i);
                        break;
                    }
                }
            }
            return new String(chars);
        }
    }

}
