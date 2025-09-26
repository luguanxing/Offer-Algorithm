package leetcode.problems;

import java.util.Arrays;

public class Test0611_有效三角形的个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().triangleNumber(
                new int[]{2, 2, 3, 4}
        ));
        System.out.println(new Solution().triangleNumber(
                new int[]{4, 2, 3, 4}
        ));
    }

    static class Solution {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int len = nums.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    // 使用二分查找找出不超过nums[i] + nums[j]的最远下标
                    int a = nums[i];
                    int b = nums[j];
                    int l = j + 1;
                    int r = len;
                    while (l < r) {
                        int mid = (l + r) / 2;
                        if (a + b > nums[mid]) {
                            l = mid + 1;
                        } else {
                            r = mid;
                        }
                    }
                    res += l - j - 1;
                }
            }

            return res;
        }
    }

    static class Solution_OLD {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int a = nums[i];
                    int b = nums[j];
                    // 找出不超过a+b最远的下标
                    int left = j;
                    int right = len;
                    int index = left;
                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (a + b > nums[mid]) {
                            // 还能组成三角形保留index，向右探索
                            index = mid;
                            left = mid + 1;
                        }
                        if (a + b <= nums[mid]) {
                            // 不能组成三角形，向左探索
                            right = mid;
                        }
                    }
                    res += index - j;
                }
            }
            return res;
        }
    }

    static class Solution_暴力 {
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int a = nums[i];
                    int b = nums[j];
                    // 找出不超过a+b最远的下标
                    for (int k = j + 1; k < len; k++) {
                        int c = nums[k];
                        if (a + b > c) {
                            res++;
                        } else {
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }

}
