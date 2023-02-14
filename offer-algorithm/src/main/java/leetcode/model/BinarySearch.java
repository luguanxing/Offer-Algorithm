package leetcode.model;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        // 二分查找模板
        // 自带库吗，找到时返回index，找不到时(-index)-1表示应在的位置
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 5, 6, 8}, 4));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 5, 6, 8}, 6));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 5, 6, 8}, 7));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 5, 6, 8}, 9));
        System.out.println();
        // 测试模板1
        System.out.println(binarySearch(new int[]{1, 2, 5, 6, 8}, 6));
        System.out.println(binarySearch(new int[]{1, 2, 5, 6, 8}, 7));
        System.out.println();
        // 测试模板2
        System.out.println(leftBound(new int[]{1, 2, 5, 5, 6, 6, 8}, 5));
        System.out.println(leftBound(new int[]{1, 2, 5, 5, 6, 6, 8}, 6));
        System.out.println();
        // 测试模板3
        System.out.println(rightBound(new int[]{1, 2, 5, 5, 6, 6, 8}, 5));
        System.out.println(rightBound(new int[]{1, 2, 5, 5, 6, 6, 8}, 6));
        System.out.println();
    }


    /*
        因为我们初始化 right = nums.length - 1
        所以决定了我们的「搜索区间」是 [left, right]
        所以决定了 while (left <= right)
        同时也决定了 left = mid+1 和 right = mid-1

        因为我们只需找到一个 target 的索引即可
        所以当 nums[mid] == target 时可以立即返回

     */
    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }


    /*
        因为我们初始化 right = nums.length
        所以决定了我们的「搜索区间」是 [left, right)
        所以决定了 while (left < right)
        同时也决定了 left = mid + 1 和 right = mid

        因为我们需找到 target 的最左侧索引
        所以当 nums[mid] == target 时不要立即返回
        而要收紧右侧边界以锁定左侧边界
     */
    static int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /*
        因为我们初始化 right = nums.length
        所以决定了我们的「搜索区间」是 [left, right)
        所以决定了 while (left < right)
        同时也决定了 left = mid + 1 和 right = mid

        因为我们需找到 target 的最右侧索引
        所以当 nums[mid] == target 时不要立即返回
        而要收紧左侧边界以锁定右侧边界

        又因为收紧左侧边界时必须 left = mid + 1
        所以最后无论返回 left 还是 right，必须减一
     */
    static int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

}
