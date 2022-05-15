package leetcode.contest.week293;

import java.util.*;

public class Test5234_移除字母异位词后的结果数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));
        System.out.println(new Solution().removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));
    }

    static class Solution {
        public List<String> removeAnagrams(String[] words) {
            Stack<String> stack = new Stack<>();
            List<String> res = new ArrayList<>();
            for (String word : words) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String flag = Arrays.toString(chars);
                if (stack.isEmpty() || !stack.peek().equals(flag)) {
                    stack.add(flag);
                    res.add(word);
                }
            }
            return res;
        }
    }

}
