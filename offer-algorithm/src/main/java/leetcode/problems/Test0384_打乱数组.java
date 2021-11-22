package leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test0384_打乱数组 {

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
    }

    static class Solution {
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        public int[] shuffle() {
            int[] res = new int[nums.length];
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            int index = 0;
            while (!list.isEmpty()) {
                int randomIndex = new Random().nextInt(list.size());
                res[index++] = list.get(randomIndex);
                list.remove(randomIndex);
            }
            return res;
        }
    }

}
