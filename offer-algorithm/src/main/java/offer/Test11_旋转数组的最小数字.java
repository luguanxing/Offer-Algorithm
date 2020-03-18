package offer;

public class Test11_旋转数组的最小数字 {

    public static void main(String[] args) {
        int[] array0 = {3, 4, 5, 1, 2};
        int[] array1 = {1, 0, 1, 1, 1};
        int[] array2 = {1, 1, 1, 0, 1};
        int[] array3 = {1, 1, 1, 1, 1};
        System.out.println(new Solution().minNumberInRotateArray(array0));
        System.out.println(new Solution().minNumberInRotateArray(array1));
        System.out.println(new Solution().minNumberInRotateArray(array2));
        System.out.println(new Solution().minNumberInRotateArray(array3));
    }

    static class Solution {
        public int minNumberInRotateArray(int[] array) {
            int start = 0;
            int end = array.length - 1;
            // 二分查找
            while (end - start > 1) {
                int mid = (start + end) / 2;
                if (array[start] < array[mid]) {
                    // mid在第一个非递减数组中
                    start = mid;
                } else if (array[mid] < array[end]) {
                    // mid在第二个非递减数组中
                    end = mid;
                } else {
                    // 中间相等，使用遍历
                    for (int index = start; index <= end; index++) {
                        if (array[index] < array[start]) {
                            return array[index];
                        }
                    }
                    // 全部相等的情况
                    break;
                }
            }
            return array[end];
        }
    }

}
