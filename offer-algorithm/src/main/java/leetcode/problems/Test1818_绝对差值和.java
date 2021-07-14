package leetcode.problems;

import java.math.BigInteger;
import java.util.TreeSet;

public class Test1818_绝对差值和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{1, 7, 5},
                new int[]{2, 3, 5}
        ));
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{2, 4, 6, 8, 10},
                new int[]{2, 4, 6, 8, 10}
        ));
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{1, 10, 4, 4, 2, 7},
                new int[]{9, 3, 5, 1, 7, 4}
        ));
        System.out.println(new Solution().minAbsoluteSumDiff(
                new int[]{1, 28, 21},
                new int[]{9, 21, 20}
        ));
    }

    static class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums1) {
                set.add(num);
            }
            // 找出替换后优化空间最大的数
            int maxImprove = 0;
            BigInteger res = new BigInteger("0");
            for (int i = 0; i < nums1.length; i++) {
                int diff = Math.abs(nums1[i] - nums2[i]);
                res = res.add(new BigInteger("" + diff));
                // 从nums1中找最接近nums2[i]的数
                int mid = set.contains(nums2[i]) ? nums2[i] : Integer.MAX_VALUE;
                int lower = set.lower(nums2[i]) == null ? Integer.MAX_VALUE : set.lower(nums2[i]);
                int higher = set.higher(nums2[i]) == null ? Integer.MAX_VALUE : set.higher(nums2[i]);
                int newDiff0 = Math.abs(mid - nums2[i]);
                int newDiff1 = Math.abs(lower - nums2[i]);
                int newDiff2 = Math.abs(higher - nums2[i]);
                maxImprove= Math.max(maxImprove, diff - newDiff0);
                maxImprove= Math.max(maxImprove, diff - newDiff1);
                maxImprove= Math.max(maxImprove, diff - newDiff2);
            }
            res = res.subtract(new BigInteger("" + maxImprove));
            res = res.mod(new BigInteger("1000000007"));
            return res.intValue();
        }
    }

    static class Solution_错误_不是替换极值最大的数 {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            // 找出差值绝对值最大的数
            int maxDiff = 0;
            int maxDiffIndex = 0;
            long res = 0;
            for (int i = 0; i < nums1.length; i++) {
                int diff = Math.abs(nums1[i] - nums2[i]);
                res += diff;
                if (diff > maxDiff) {
                    maxDiff = Math.max(maxDiff, diff);
                    maxDiffIndex = i;
                }
            }
            // 看看nums1哪个数最接近nums2[maxDiffIndex]则用它来取代原nums1[maxDiffIndex]
            int cloestDiff = Integer.MAX_VALUE;
            for (int i = 0; i < nums1.length; i++) {
                int diff = Math.abs(nums1[i] - nums2[maxDiffIndex]);
                if (diff < cloestDiff) {
                    cloestDiff = diff;
                }
            }
            res = res - Math.abs(nums2[maxDiffIndex] - nums1[maxDiffIndex]) + cloestDiff;
            return (int) res % 1000000007;
        }
    }

}
