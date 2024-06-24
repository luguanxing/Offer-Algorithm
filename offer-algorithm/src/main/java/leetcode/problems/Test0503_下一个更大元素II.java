package leetcode.problems;

import java.util.*;

public class Test0503_下一个更大元素II {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int[]{1, 5, 3, 6, 8})));
    }

    static class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int len = nums.length;
            // 存两遍处理循环
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            list.addAll(list);
            // 单调栈，将不比自己大的数挤出
            int[] res = new int[len];
            List<Integer> queue = new LinkedList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                int num = list.get(i);
                while (!queue.isEmpty() && queue.get(0) <= num) {
                    queue.remove(0);
                }
                // 找单调栈内下一个更大元素
                if (queue.isEmpty()) {
                    res[i % len] = -1;
                } else {
                    res[i % len] = queue.get(0);
                }
                queue.add(0, num);
            }
            return res;
        }
    }

}
