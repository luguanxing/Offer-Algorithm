package leetcode.problems;

public class Test1616_分割两个字符串得到回文串 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkPalindromeFormation("xy", "ab"));
        System.out.println(new Solution().checkPalindromeFormation("x", "y"));
        System.out.println(new Solution().checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println(new Solution().checkPalindromeFormation("abdef", "fecab"));
        System.out.println(new Solution().checkPalindromeFormation("cddbcdbdc", "cdbccbddc"));
        System.out.println(new Solution().checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
        System.out.println(new Solution_暴力().checkPalindromeFormation("aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
    }

    static class Solution {
        public boolean checkPalindromeFormation(String a, String b) {
            // 只需判断四种情况：a, b, aP+bS, bP+aS
            // 判断a, b
            if (isPanlindrom(a) || isPanlindrom(b)) {
                return true;
            }
            // 判断aP+bS, bP+aS，注意直接从最长位找起匹配即可
            if (isOk(a, b) || isOk(b, a)) {
                return true;
            }
            return false;
        }

        private boolean isOk(String a, String b) {
            // 先匹配出最长aPrefix和bSuffix
            int len = a.length();
            int idx = 0;
            while (a.charAt(idx) == b.charAt(len - idx - 1)) {
                idx++;
                if (idx >= b.length() - idx) {
                    return true;
                }
            }
            // 判断剩下的a[idx:len-idx] 或 b[idx:len-idx], 如果是回文串加上对应的aPrefix和bSuffix则可得到完整结果
            return isPanlindrom(a.substring(idx, len - idx)) || isPanlindrom(b.substring(idx, len - idx));
        }

        private boolean isPanlindrom(String str) {
            int l = 0;
            int r = str.length() - 1;
            while (l <= r) {
                if (str.charAt(l) != str.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

    static class Solution_暴力 {
        public boolean checkPalindromeFormation(String a, String b) {
            int len = a.length();
            for (int i = 0; i <= len; i++) {
                String aPrefix = a.substring(0, i);
                String bPrefix = b.substring(0, i);
                String aSuffix = a.substring(i);
                String bSuffix = b.substring(i);
                if (isPanlindrom(aPrefix + bSuffix) || isPanlindrom(bPrefix + aSuffix)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isPanlindrom(String str) {
            int l = 0;
            int r = str.length() - 1;
            while (l <= r) {
                if (str.charAt(l) != str.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            System.out.println(str);
            return true;
        }
    }

}
