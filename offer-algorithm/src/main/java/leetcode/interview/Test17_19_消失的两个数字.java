package leetcode.interview;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Test17_19_消失的两个数字 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{1})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{2, 3})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{3, 4})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{3, 4, 5})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{1, 4})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{1, 2, 4})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{1, 2, 5})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{1, 2, 5, 6})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{1, 2, 3, 4, 6, 7, 9, 10})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{3})));
        System.out.println(Arrays.toString(new Solution_set().missingTwo(new int[]{2})));
    }

    static class Solution {
        public int[] missingTwo(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            int max = Arrays.stream(nums).max().getAsInt();
            if (max == len) {
                return new int[]{max + 1, max + 2};
            } else if (max == len + 1) {
                int[] res = new int[2];
                res[1] = max + 1;
                int idx = 1;
                for (int num : nums) {
                    if (num != idx) {
                        res[0] = idx;
                        break;
                    }
                    idx++;
                }
                return res;
            } else {
                int[] res = new int[2];
                int idx = 1;
                for (int num : nums) {
                    if (num != idx) {
                        res[0] = idx;
                        break;
                    }
                    idx++;
                }
                if (res[0] == 0) {
                    res[0] = idx;
                }
                idx = max;
                for (int i = len - 1; i >= 0; i--) {
                    int num = nums[i];
                    if (num != idx) {
                        res[1] = idx;
                        break;
                    }
                    idx--;
                }
                if (res[1] == 0) {
                    res[1] = idx;
                }
                return res;
            }
        }
    }

    static class Solution_set {
        public int[] missingTwo(int[] nums) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int max = Arrays.stream(nums).max().getAsInt();
            int[] res = new int[2];
            int cnt = 0;
            for (int i = 1; i <= max+2; i++) {
                if (!set.contains(i)) {
                    res[cnt++] = i;
                }
                if (cnt == 2) {
                    break;
                }
            }
            return res;
        }
    }

}
