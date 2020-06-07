package leetcode.contest.week192;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5429_数组中的k个最强值 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getStrongest(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(new Solution().getStrongest(new int[]{1, 1, 3, 5, 5}, 2)));
        System.out.println(Arrays.toString(new Solution().getStrongest(new int[]{6, 7, 11, 7, 6, 8}, 5)));
        System.out.println(Arrays.toString(new Solution().getStrongest(new int[]{6, -3, 7, 2, 11}, 3)));
        System.out.println(Arrays.toString(new Solution().getStrongest(new int[]{-7, 22, 17, 3}, 2)));
    }

    static class Solution {
        public int[] getStrongest(int[] arr, int k) {
            if (arr == null) {
                return null;
            }
            // 排序，计算中位数
            Arrays.sort(arr);
            int mid = arr[(arr.length - 1) / 2];
            // 利用中位数绝对值差排序
            int[] result = new int[k];
            List<Integer> sortList = Arrays
                    .stream(arr)
                    .boxed()
                    .sorted(
                            (num1, num2) -> {
                                int d1 = Math.abs(num1 - mid);
                                int d2 = Math.abs(num2 - mid);
                                if (d1 != d2) {
                                    return d2 - d1;
                                } else {
                                    return num2 - num1;
                                }
                            }
                    )
                    .collect(Collectors.toList());
            // 返回结果
            for (int i = 0; i < k; i++) {
                result[i] = sortList.get(i);
            }
            return result;
        }
    }

}
