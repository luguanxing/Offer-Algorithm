package leetcode.contest.week200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test5476_找出数组游戏的赢家 {

    public static void main(String[] args) {
        System.out.println(new Solution().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(new Solution().getWinner(new int[]{3, 2, 1}, 10));
        System.out.println(new Solution().getWinner(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(new Solution().getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }

    static class Solution {
        public int getWinner(int[] arr, int k) {
            // 拼接自身便于比较
            List<Integer> list = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            list.addAll(list);
            // 暴力统计右边数目
            if (k > arr.length) {
                k = arr.length;
            }
            for (int i = 0; i < arr.length; i++) {
                int cnt = k;
                if (i > 0 && arr[i - 1] < arr[i]) {
                    cnt = k - 1;
                }
                boolean isOk = true;
                for (int j = 1; j <= cnt; j++) {
                    if (list.get(i) < list.get(i + j)) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    return list.get(i);
                }
            }
            return 0;
        }
    }

}
