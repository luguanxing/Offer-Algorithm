package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test1807_替换字符串中的括号内容 {

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
                "(fy)(kj)(ege)r",
                Arrays.asList(
                        Arrays.asList("uxhhkpvp", "h"),
                        Arrays.asList("nriroroa", "m"),
                        Arrays.asList("wvhiycvo", "z"),
                        Arrays.asList("qsmfeing", "s"),
                        Arrays.asList("hbcyqulf", "q"),
                        Arrays.asList("xwgfjnrf", "b"),
                        Arrays.asList("kfipazun", "s"),
                        Arrays.asList("wnkrtxui", "u"),
                        Arrays.asList("abwlsese", "e"),
                        Arrays.asList("iimsmftc", "h"),
                        Arrays.asList("pafqkquo", "v"),
                        Arrays.asList("kj", "tzv"),
                        Arrays.asList("fwwxotcd", "t"),
                        Arrays.asList("yzgjjwjr", "l")
                )
        ));
    }

    static class Solution {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> kv : knowledge) {
                map.put(kv.get(0), kv.get(1));
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c != ')') {
                    stack.add(c);
                    continue;
                }
                String current = "";
                while (!stack.isEmpty() && stack.peek() != '(') {
                    current = stack.pop() + current;
                }
                stack.pop();
                for (char cc : map.getOrDefault(current, "?").toCharArray()) {
                    stack.add(cc);
                }
            }
            return stack.stream().map(c -> "" + c).collect(Collectors.joining());
        }
    }

    static class Solution_超时 {
        public String evaluate(String s, List<List<String>> knowledge) {
            Map<String, String> map = new HashMap<>();
            for (List<String> kv : knowledge) {
                map.put(kv.get(0), kv.get(1));
            }
            for (String k : map.keySet()) {
                String v = map.get(k);
                s = s.replaceAll("\\(" + k + "\\)", v);
            }
            s = s.replaceAll("(?<=\\()[^\\)]+", "?").replaceAll("\\(\\?\\)", "?");
            return s;
        }
    }

}
