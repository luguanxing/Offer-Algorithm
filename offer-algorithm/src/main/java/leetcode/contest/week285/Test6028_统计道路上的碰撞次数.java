package leetcode.contest.week285;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test6028_统计道路上的碰撞次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countCollisions("RLRSLL"));
        System.out.println(new Solution().countCollisions("LLRR"));
        System.out.println(new Solution().countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
        System.out.println(new Solution().countCollisions("SRRLRLRSRLRSSRRLSLRLLRSLSLLSSRRLSRSLSLRRS"));
        System.out.println(new Solution().countCollisions("LSSSLLSSSSLRRSLLLSLSLRRLLLLLRSSRSRRSLLLSSS"));
    }

    static class Solution {
        public int countCollisions(String directions) {
            int res = 0;
            Stack<Character> stack = new Stack<>();
            for (char c : directions.toCharArray()) {
                if (c == 'L') {
                    if (!stack.isEmpty()) {
                        if (stack.peek() == 'R') {
                            res += 2;
                        } else if (stack.peek() == 'S') {
                            res++;
                        }
                        stack.pop();
                        stack.add('S');
                        stack.add('S');
                    }
                } else if (c == 'S') {
                    if (!stack.isEmpty() && stack.peek() == 'R') {
                        res++;
                        stack.pop();
                        stack.add('S');
                    }
                    stack.add('S');
                } else if (c == 'R') {
                    stack.add('R');
                }
            }
            // 中间被卡住的R和L需要计算
            while (!stack.isEmpty() && stack.peek() == 'R') {
                stack.pop();
            }
            List<Character> list = new ArrayList<>(stack);
            while (!list.isEmpty() && list.get(0) == 'L') {
                list.remove(0);
            }
            // 计算剩余中间被卡住的R和L
            for (char c : list) {
                if (c != 'S') {
                    res++;
                }
            }
            return res;
        }
    }

}
