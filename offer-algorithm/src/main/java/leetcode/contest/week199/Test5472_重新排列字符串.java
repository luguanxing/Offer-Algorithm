package leetcode.contest.week199;

public class Test5472_重新排列字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(new Solution().restoreString("abc", new int[]{0, 1, 2}));
        System.out.println(new Solution().restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
        System.out.println(new Solution().restoreString("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
        System.out.println(new Solution().restoreString("art", new int[]{1, 0, 2}));
    }

    static class Solution {
        public String restoreString(String s, int[] indices) {
            if (s == null) {
                return null;
            }
            if (s.isEmpty()) {
                return "";
            }
            char[] chars = s.toCharArray();
            char[] res = new char[indices.length];
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int index = indices[i];
                res[index] = c;
            }
            return new String(res);
        }
    }

}
