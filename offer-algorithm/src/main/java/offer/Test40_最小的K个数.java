package offer;

import java.util.ArrayList;

public class Test40_最小的K个数 {

    public static void main(String[] args) {
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 3));
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 8));
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 10));
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 0));
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{}, 10));
        System.out.println(new Solution().GetLeastNumbers_Solution(new int[]{}, 0));
    }

    static class Solution {
        public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
            if (input == null) {
                return null;
            }
            if (k > input.length || input.length == 0) {
                return new ArrayList<>();
            }
            int left = 0;
            int right = input.length - 1;
            int index = -1;
            // 划分大小两部分确定第K大元素，并反复逼近
            do {
                index = partition(input, left, right);
                if (index == k) {
                    break;
                } else if (index < k) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            } while (index != k && left <= right);
            // 取出前k个元素
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                result.add(input[i]);
            }
            return result;
        }

        public int partition(int[] nums, int start, int end) {
            if (start == end) {
                return start;
            }
            // 取第一个元素作基准元素划分左右两部分
            int index = nums[start];
            ArrayList<Integer> smallerPart = new ArrayList<>();
            ArrayList<Integer> biggerPart = new ArrayList<>();
            for (int i = start + 1; i <= end; i++) {
                if (nums[i] < index) {
                    smallerPart.add(nums[i]);
                } else {
                    biggerPart.add(nums[i]);
                }
            }
            // 重新对nums排序
            for (int i = 0; i < smallerPart.size(); i++) {
                nums[start + i] = smallerPart.get(i);
            }
            nums[start + smallerPart.size()] = index;
            for (int i = 0; i < biggerPart.size(); i++) {
                nums[index + i] = biggerPart.get(i);
            }
            return start + 1;
        }
    }

}
