package leetcode.contest.week283;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test6019_替换数组中的非互质数 {

    public static void main(String[] args) {
        System.out.println(new Solution().replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}));
        System.out.println(new Solution().replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3}));
        System.out.println(new Solution().replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561}));
        System.out.println(new Solution().replaceNonCoprimes(new int[]{287, 41, 49, 287, 899, 23, 23, 20677, 5, 825}));
    }

    static class Solution {
        public List<Integer> replaceNonCoprimes(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            stack.push(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int current = nums[i];
                // 每个数放入前需要先和栈内的元素尝试化简
                while (!stack.isEmpty()) {
                    int last = stack.peek();
                    int gcd = gcd(last, current);
                    if (gcd > 1) {
                        stack.pop();
                        current = (int)((long) current * last / gcd);
                    } else {
                        break;
                    }
                }
                // 化简完成后再放入栈中
                stack.push(current);
            }
            return new ArrayList<>(stack);
        }

        private int gcd(int a, int b) {
            if (b == 0) {
                return a;
            } else {
                return gcd(b, a % b);
            }
        }
    }

}
