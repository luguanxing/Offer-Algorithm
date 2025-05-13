package leetcode.problems;

public class Test3335_字符串转换后的长度I {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthAfterTransformations("abcyy", 2));
        System.out.println(new Solution().lengthAfterTransformations("azbk", 1));
        System.out.println(new Solution().lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));
    }

    static class Solution {
        public int lengthAfterTransformations(String s, int t) {
            int MOD = (int) (1e9 + 7);
            int[] map = new int[26];
            for (char c : s.toCharArray()) {
                map[c - 'a']++;
            }
            // 使用z指针，实际每次变换相当于给z后面的b增加z个数
            int zIndex = 25;
            for (int i = 1; i <= t; i++) {
                // 当前z个数
                int add = map[zIndex--];
                // z下一个+1正常变成a无需额外计数，z下两个+2变成b需要额外计数加上add
                map[(zIndex + 2) % 26] += add;
                map[(zIndex + 2) % 26] %= MOD;
                if (zIndex < 0) {
                    zIndex = 25;
                }
            }
            int res = 0;
            for (int cnt : map) {
                res += cnt;
                res %= MOD;
            }
            return res;
        }
    }

}
