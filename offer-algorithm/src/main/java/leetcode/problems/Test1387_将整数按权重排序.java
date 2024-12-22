package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1387_将整数按权重排序 {

    public static void main(String[] args) {
        System.out.println(new Solution_记忆化().getKth(12, 15, 2));
        System.out.println(new Solution_记忆化().getKth(7, 11, 4));
    }

    static class Solution {
        public int getKth(int lo, int hi, int k) {
            int len = hi - lo + 1;
            int[][] nums = new int[len][2];
            for (int i = 0; i < len; i++) {
                int num = lo + i;
                nums[i][0] = num;
                nums[i][1] = getWeight(num);
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            return nums[k - 1][0];
        }

        private int getWeight(int num) {
            int weight = 0;
            while (num != 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = num * 3 + 1;
                }
                weight++;
            }
            return weight;
        }
    }

    static class Solution_记忆化 {
        Map<Integer, Integer> map = new HashMap<>();

        public int getKth(int lo, int hi, int k) {
            int len = hi - lo + 1;
            int[][] nums = new int[len][2];
            for (int i = 0; i < len; i++) {
                int num = lo + i;
                nums[i][0] = num;
                nums[i][1] = getWeight(num);
            }
            Arrays.sort(nums, (o1, o2) -> {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            return nums[k - 1][0];
        }

        private int getWeight(int num) {
            if (num == 1) {
                return 0;
            }
            if (map.containsKey(num)) {
                return map.get(num);
            }
            int weight = 1;
            if (num % 2 == 0) {
                weight += getWeight(num / 2);
            } else {
                weight += getWeight(num * 3 + 1);
            }
            map.put(num, weight);
            return weight;
        }
    }

}
