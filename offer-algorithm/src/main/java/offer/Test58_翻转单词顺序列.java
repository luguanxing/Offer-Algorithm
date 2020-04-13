package offer;

import java.util.Stack;
import java.util.stream.Stream;

public class Test58_翻转单词顺序列 {

    public static void main(String[] args) {
//        System.out.println(new Solution().ReverseSentence("I am a student."));
        System.out.println(new Solution().ReverseSentence(" "));
//        System.out.println(new Solution().ReverseSentence(null));
    }

    static class Solution {
        public String ReverseSentence(String str) {
            if (str == null || str.trim().equals("")) {
                return str;
            }
            Stack<String> stack = new Stack<>();
            // 所有分割单词放入栈中
            Stream.of(str.split(" ")).forEach(stack::push);
            String result = "";
            while (!stack.isEmpty()) {
                result += stack.pop() + " ";
            }
            return result.length() > 2 ? result.substring(0, result.length() - 1) : "";
        }
    }

}
