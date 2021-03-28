package leetcode.contest.week234;

import java.util.*;

public class Test5714_替换字符串中的括号内容 {

    public static void main(String[] args) {
        System.out.println(new Solution().evaluate(
                "(name)is(age)yearsold",
                Arrays.asList(
                        Arrays.asList("name", "bob"),
                        Arrays.asList("age", "two")
                )
        ));
        System.out.println(new Solution().evaluate(
                "hi(name)",
                Arrays.asList(
                        Arrays.asList("a", "b")
                )
        ));
        System.out.println(new Solution().evaluate(
                "(a)(a)(a)aaa",
                Arrays.asList(
                        Arrays.asList("a", "yes")
                )
        ));
        System.out.println(new Solution().evaluate(
                "(a)(b)",
                Arrays.asList(
                        Arrays.asList("a", "b"),
                        Arrays.asList("b", "a")
                )
        ));
    }

    static class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> list : knowledge) {
                String key = list.get(0);
                String word = list.get(1);
                map.put(key, word);
            }
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c != ')') {
                    deque.addLast(c);
                } else {
                    String key = "";
                    while (deque.peekLast() != '(') {
                        char w = deque.pollLast();
                        key = w + key;
                    }
                    deque.pollLast();
                    String value = map.getOrDefault(key, "?");
                    for (char v : value.toCharArray()) {
                        deque.addLast(v);
                    }
                }
            }
            String res = "";
            while (!deque.isEmpty()) {
                res += deque.pollFirst();
            }
            return res;
        }
    }

}
