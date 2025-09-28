package leetcode.problems;

import java.util.Arrays;
import java.util.TreeMap;

public class Test0976_三角形的最大周长 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestPerimeter(new int[]{2, 1, 2}));
        System.out.println(new Solution().largestPerimeter(new int[]{1, 2, 1, 10}));
    }

    static class Solution {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            // 假设a <= b <= c, 则只需要判断 a + b > c 是否成立
            // 因为a和b已经是最大的两个边了（贪心）
            for (int i = len - 1; i >= 2; i--) {
                int a = nums[i];
                int b = nums[i - 1];
                int c = nums[i - 2];
                if (b + c > a) {
                    return a + b + c;
                }
            }
            return 0;
        }
    }

    static class Solution_OLD {
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int len = nums.length;
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    int a = nums[i];
                    int b = nums[j];
                    map.put(a, map.get(a) - 1);
                    map.put(b, map.get(b) - 1);
                    Integer c = map.lowerKey(a + b);
                    if (c != null && map.get(c) > 0) {
                        return a + b + c;
                    }
                    map.put(a, map.get(a) + 1);
                    map.put(b, map.get(b) + 1);
                }
            }
            return 0;
        }
    }

}
