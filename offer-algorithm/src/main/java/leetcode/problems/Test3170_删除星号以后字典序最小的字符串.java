package leetcode.problems;

import java.util.*;

public class Test3170_删除星号以后字典序最小的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().clearStars("aaba*"));
        System.out.println(new Solution().clearStars("abc"));
    }

    static class Solution {
        public String clearStars(String s) {
            // 使用一个Map来记录每个字符的出现位置
            Map<Character, List<Integer>> charIndexs = new HashMap<>();
            for (char x = 'a'; x <= 'z'; x++) {
                charIndexs.put(x, new ArrayList<>());
            }
            // 遍历字符串，处理每个字符
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 正常字符记录index
                if (c != '*') {
                    charIndexs.get(c).add(i);
                    continue;
                }
                // 星号删除前面最小的字符
                for (char x = 'a'; x <= 'z'; x++) {
                    List<Integer> indexes = charIndexs.get(x);
                    if (!indexes.isEmpty()) {
                        // 删除第一个出现的字符
                        indexes.remove(indexes.size() - 1);
                        break;
                    }
                }
            }
            // 构建结果字符串
            char[] ans = new char[s.length()];
            for (char x = 'a'; x <= 'z'; x++) {
                List<Integer> indexes = charIndexs.get(x);
                for (int index : indexes) {
                    ans[index] = x;
                }
            }
            return new String(ans).replace("\0", "");
        }
    }

}
