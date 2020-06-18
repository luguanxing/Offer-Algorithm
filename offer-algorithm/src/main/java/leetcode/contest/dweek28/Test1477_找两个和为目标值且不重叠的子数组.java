package leetcode.contest.dweek28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test1477_找两个和为目标值且不重叠的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3));
        System.out.println(new Solution().minSumOfLengths(new int[]{7, 3, 4, 7}, 7));
        System.out.println(new Solution().minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6));
        System.out.println(new Solution().minSumOfLengths(new int[]{5, 5, 4, 4, 5}, 3));
        System.out.println(new Solution().minSumOfLengths(new int[]{3, 1, 1, 1, 5, 1, 2, 1}, 3));
        System.out.println(new Solution().minSumOfLengths(new int[]{1, 2, 2, 3, 2, 6, 7, 2, 1, 4, 8}, 5));
        System.out.println(new Solution().minSumOfLengths(new int[]{1, 6, 1}, 7));
        System.out.println(new Solution().minSumOfLengths(new int[]{1, 1, 1, 2, 2, 2, 4, 4}, 6));
    }

    static class Solution {
        public int minSumOfLengths(int[] arr, int target) {
            // 滑动保存所有和为target的left和right
            List<TargetPair> targetPairList = new ArrayList<>();
            int left = 0;
            int right = 0;
            int curSum = 0;
            while (right < arr.length) {
                curSum += arr[right];
                while (curSum >= target) {
                    if (curSum == target) {
                        targetPairList.add(new TargetPair(left, right));
                        break;
                    }
                    curSum -= arr[left++];
                }
                right++;
            }
            // 从结果中找出不重叠的最小数组
            targetPairList.sort(Comparator.comparingInt(pair -> (pair.right - pair.left)));
            Integer min = Integer.MAX_VALUE;
            for (int i = 0; i < targetPairList.size(); i++) {
                for (int j = i + 1; j < targetPairList.size(); j++) {
                    TargetPair pair1 = targetPairList.get(i);
                    TargetPair pair2 = targetPairList.get(j);
                    // 后面长度更长的情况下可以剪枝
                    if (min <= (pair1.right - pair1.left) * 2) {
                        break;
                    }
                    if (min <= pair1.right - pair1.left + pair2.right - pair2.left + 2) {
                        break;
                    }
                    if (pair1.right < pair2.left || pair2.right < pair1.left) {
                        min = Math.min(min, pair1.right - pair1.left + pair2.right - pair2.left + 2);
                        break;
                    }
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        static class TargetPair {
            int left;
            int right;

            public TargetPair(int left, int right) {
                this.left = left;
                this.right = right;
            }

            @Override
            public String toString() {
                return "(" + left + "," + right + ")";
            }
        }
    }

}
