package leetcode.problems;

import java.util.*;

public class Test0015_三数之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(new Solution().threeSum(new int[]{-2, 0, 1, 1, 2}));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 先排序
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            Set<String> existed = new HashSet<>();
            // 双指针凑数
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < nums.length && 0 <= right && left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        List<Integer> array = Arrays.asList(nums[i], nums[left], nums[right]);
                        if (!existed.contains(array.toString())) {
                            result.add(array);
                            existed.add(array.toString());
                        }
                        left++;
                    }
                }
            }
            return result;
        }
    }

    static class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            int len = nums.length;
            Arrays.sort(nums);
            Set<String> set = new HashSet<>();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int diff = -nums[i] - nums[j];
                    if (Arrays.binarySearch(nums, j + 1, len, diff) > 0) {
                        List<Integer> srt = new ArrayList<>();
                        srt.add(nums[i]);
                        srt.add(nums[j]);
                        srt.add(diff);
                        Collections.sort(srt);
                        if (!set.contains(srt.toString())) {
                            set.add(srt.toString());
                        } else {
                            continue;
                        }
                        list.add(srt);
                    }
                }
            }
            return list;
        }
    }

}
