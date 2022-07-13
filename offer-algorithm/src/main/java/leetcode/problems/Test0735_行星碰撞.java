package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test0735_行星碰撞 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{8, -8})));
        System.out.println(Arrays.toString(new Solution().asteroidCollision(new int[]{10, 2, -5})));
    }

    static class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            // 列表存储向左飞的陨石
            List<Integer> list = new ArrayList<>();
            // 栈存储向右飞的陨石
            Stack<Integer> stack = new Stack<>();
            for (int asteroid : asteroids) {
                if (stack.isEmpty()) {
                    // 当前没有向右飞陨石的情况，直接加入列表或栈
                    if (asteroid < 0) {
                        list.add(asteroid);
                    } else {
                        stack.add(asteroid);
                    }
                } else {
                    // 当前已有向右飞陨石的情况，需要根据当前陨石情况处理
                    if (asteroid > 0) {
                        // 若当前陨石也右飞加入则栈
                        stack.add(asteroid);
                    } else {
                        // 若当前陨石左飞则需要和栈内右飞的陨石碰一碰
                        while (!stack.isEmpty() && stack.peek() + asteroid < 0) {
                            stack.pop();
                        }
                        if (!stack.isEmpty() && (stack.peek() + asteroid == 0)) {
                            stack.pop();
                            continue;
                        } else if (!stack.isEmpty() && (stack.peek() + asteroid > 0)) {
                            continue;
                        } else if (stack.isEmpty()) {
                            list.add(asteroid);
                        }
                    }
                }
            }
            list.addAll(stack);
            // 返回剩下结果
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
