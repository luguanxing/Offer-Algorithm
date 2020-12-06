package leetcode.contest.week218;

public class Test5617_设计Goal解析器 {

    public static void main(String[] args) {
        System.out.println(new Solution().interpret("G()(al)"));
        System.out.println(new Solution().interpret("G()()()()(al)"));
        System.out.println(new Solution().interpret("(al)G(al)()()G"));
    }

    static class Solution {
        public String interpret(String command) {
            command = command.replaceAll("\\(\\)", "o");
            command = command.replaceAll("\\(al\\)", "al");
            return command;
        }
    }

}
