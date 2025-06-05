package leetcode.problems;

public class Test1061_按字典序排列最小的等效字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestEquivalentString("abc", "cde", "eed"));
        System.out.println(new Solution().smallestEquivalentString("parker", "morris", "parser"));
        System.out.println(new Solution().smallestEquivalentString("hello", "world", "hold"));
        System.out.println(new Solution().smallestEquivalentString("leetcode", "programs", "sourcecode"));
    }

    static class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            // 并查集map[i]=char[26]表示等价最小的字符串
            char[] map = new char[256];
            for (char c = 'a'; c <= 'z'; c++) {
                map[c] = c;
            }
            // 构建并查集
            for (int k = 1; k <= 26; k++) {
                for (int i = 0; i < s1.length(); i++) {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    char c1root = map[c1];
                    while (map[c1root] != c1root) {
                        c1root = map[c1root];
                    }
                    char c2root = map[c2];
                    while (map[c2root] != c2root) {
                        c2root = map[c2root];
                    }
                    if (c1root < c2root) {
                        map[c1] = c1root;
                        map[c2] = c1root;
                    } else if (c1root > c2root) {
                        map[c1] = c2root;
                        map[c2] = c2root;
                    }
                }
            }
            // 构建baseStr答案
            StringBuilder sb = new StringBuilder();
            for (char c : baseStr.toCharArray()) {
                while (map[c] != c) {
                    c = map[c];
                }
                sb.append(c);
            }
            return sb.toString();
        }
    }

}
