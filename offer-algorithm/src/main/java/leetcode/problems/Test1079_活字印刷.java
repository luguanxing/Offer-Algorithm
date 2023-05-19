package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test1079_活字印刷 {

    public static void main(String[] args) {
        System.out.println(new Solution().numTilePossibilities("AAB"));
        System.out.println(new Solution().numTilePossibilities("AAABBC"));
        System.out.println(new Solution().numTilePossibilities("V"));
    }

    static class Solution {
        Set<String> result = new HashSet<>();
        List<Character> cList = new ArrayList<>();
        List<Character> current = new ArrayList<>();

        public int numTilePossibilities(String tiles) {
            for (char c : tiles.toCharArray()) {
                cList.add(c);
            }
            dfs();
            return result.size() - 1;
        }

        private void dfs() {
            result.add(current.toString());
            for (int i = 0; i < cList.size(); i++) {
                // 取字母
                char c = cList.get(i);
                cList.remove(i);
                current.add(c);
                dfs();
                current.remove(current.size() - 1);
                cList.add(i, c);
            }
        }
    }

}
