package leetcode.problems;

public class Test0686_重复叠加字符串匹配 {

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(new Solution().repeatedStringMatch("a", "aa"));
        System.out.println(new Solution().repeatedStringMatch("a", "a"));
        System.out.println(new Solution().repeatedStringMatch("abc", "wxyz"));
        System.out.println(new Solution().repeatedStringMatch("aa", "a"));
        System.out.println(new Solution().repeatedStringMatch("bb", "bbbbbbb"));
        System.out.println(new Solution().repeatedStringMatch("abcd", "abcdb"));
        System.out.println(new Solution().repeatedStringMatch("abc", "aabcbabcc"));
        System.out.println(new Solution().repeatedStringMatch("abcd", "bc"));

    }

    static class Solution {
        public int repeatedStringMatch(String a, String b) {
            int cnt = 0;
            while (b.contains(a)) {
                b = b.replaceFirst(a, " ");
                cnt++;
            }
            int wordCnt = 0;
            for (String word : b.split(" ")) {
                if (!word.isEmpty()) {
                    wordCnt++;
                }
            }
            if (wordCnt > 2) {
                return -1;
            }
            b = b.replaceAll(" ", "");
            if (!b.isEmpty()) {
                if (a.contains(b)) {
                    if (a.startsWith(b) || a.endsWith(b) || cnt == 0) {
                        cnt += 1;
                    } else {
                        return -1;
                    }
                } else if ((a + a).contains(b)) {
                    cnt += 2;
                } else {
                    return -1;
                }
            }
            return cnt;
        }
    }

//    题解：先判断字符，再尝试N+2次
//    static class Solution {
//        public int repeatedStringMatch(String a, String b) {
//            // 如果b里面有a不存在的字符，直接返回-1
//            boolean[] arr = new boolean[26];
//            for (int i = 0; i < a.length(); i++) {
//                arr[a.charAt(i) - 'a'] = true;
//            }
//            for (int i = 0; i < b.length(); i++) {
//                if (!arr[b.charAt(i) - 'a']) {
//                    return -1;
//                }
//            }
//
//            int count = b.length() / a.length();
//            StringBuilder sb = new StringBuilder(a.repeat(count));
//            for (int i = 0; i <= 2; i++) {
//                if (sb.indexOf(b) >= 0) {
//                    return count + i;
//                }
//                sb.append(a);
//            }
//
//            return -1;
//        }
//    }

}
