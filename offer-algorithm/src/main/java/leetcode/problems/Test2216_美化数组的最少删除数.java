package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test2216_美化数组的最少删除数 {

    public static void main(String[] args) {
        // nums = [1,1,2,3,5]
        System.out.println(new Solution().minDeletion(new int[]{1, 1, 2, 3, 5}));
        // nums = [1,1,2,2,3,3]
        System.out.println(new Solution().minDeletion(new int[]{1, 1, 2, 2, 3, 3}));
    }

    static class Solution {
        public int minDeletion(int[] nums) {
            Stack<Integer> stack = new Stack<>();
            stack.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                if (stack.size() % 2 == 1 && num == stack.peek()) {
                    continue;
                }
                stack.add(num);
            }
            if (stack.size() % 2 == 1) {
                stack.pop();
            }
            return nums.length - stack.size();
        }
    }

    static class Solution1 {
        public int minDeletion(int[] nums) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int idx1 = 0;
            while (idx1 < list.size()) {
                if (idx1 == list.size() - 1) {
                    break;
                }
                int num1 = list.get(idx1);
                int idx2 = idx1 + 1;
                while (idx2 < list.size()) {
                    int num2 = list.get(idx2);
                    if (num2 == num1) {
                        list.remove(idx2);
                    } else {
                        idx1 = idx2 + 1;
                        break;
                    }
                }
            }
            if (list.size() % 2 == 1) {
                list.remove(list.size() - 1);
            }
            return nums.length - list.size();
        }
    }

}
