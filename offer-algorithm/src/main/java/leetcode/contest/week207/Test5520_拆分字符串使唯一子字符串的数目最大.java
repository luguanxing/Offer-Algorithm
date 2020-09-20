package leetcode.contest.week207;

import java.util.*;

public class Test5520_拆分字符串使唯一子字符串的数目最大 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxUniqueSplit("ababccc"));
        System.out.println(new Solution().maxUniqueSplit("aba"));
        System.out.println(new Solution().maxUniqueSplit("aa"));
        System.out.println(new Solution().maxUniqueSplit("addbsd"));
        System.out.println(new Solution().maxUniqueSplit("addbs"));
        System.out.println(new Solution().maxUniqueSplit("fcmfacp"));
    }

    static class Solution {
        Set<String> current = new HashSet<>();
        int max = Integer.MIN_VALUE;

        public int maxUniqueSplit(String s) {
            dfs(s);
            return max;
        }

        private void dfs(String last) {
            if (last.isEmpty()) {
                max = Math.max(max, current.size());
            }
            for (int i = last.length() - 1; i >= 0; i--) {
                String lastStr = last.substring(i);
                if (!current.contains(lastStr)) {
                    current.add(lastStr);
                    dfs(last.substring(0, i));
                    current.remove(lastStr);
                }
            }
        }
    }

}
