package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test0134_加油站 {

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 4, 5, 1, 2}
        ));
        System.out.println(new Solution().canCompleteCircuit(
                new int[]{2, 3, 4},
                new int[]{3, 4, 3}
        ));
    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            int[] gasCircuit = new int[len * 2];
            for (int i = 0; i < len; i++) {
                gasCircuit[i] = gas[i] - cost[i];
                gasCircuit[i + len] = gasCircuit[i];
            }
            // 滑动窗口找是否存在解
            int sum = 0;
            int l = 0;
            int r = 0;
            while (l <= r && r < 2 * len) {
                sum += gasCircuit[r++];
                while (sum < 0) {
                    sum -= gasCircuit[l++];
                }
                if (r - l == len) {
                    return l;
                }
            }
            return -1;
        }
    }

    static class Solution_优化 {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            // 如果总油量小于总消耗无法走完
            int left = Arrays.stream(gas).sum() - Arrays.stream(cost).sum();
            if (left < 0) {
                return -1;
            }
            // 计算每步能向后多少，当前点如果走不过去则绕后，因为left>0最后必能走完
            int len = gas.length;
            int[] forward = new int[len];
            for (int i = 0; i < len; i++) {
                forward[i] = gas[i] - cost[i];
            }
            int start = 0;
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += forward[i];
                if (sum < 0) {
                    start = i + 1;
                    sum = 0;
                }
            }
            return start;
        }
    }

    static class Solution_OLD {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            List<Integer> forwardList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                forwardList.add(gas[i] - cost[i]);
            }
            // 从i开始看看能不能连续走len步
            forwardList.addAll(forwardList);
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = i; j < i + len; j++) {
                    sum += forwardList.get(j);
                    if (sum < 0) {
                        break;
                    }
                }
                if (sum >= 0) {
                    return i;
                }
            }
            return -1;
        }
    }

}
