package leetcode.contest.week401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test100319_执行操作可获得的最大总奖励I {

    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(new Solution().maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }

    static class Solution {
        public int maxTotalReward(int[] rewardValues) {
            Arrays.sort(rewardValues);
            TreeSet<Integer> set = new TreeSet<>();
            for (int value : rewardValues) {
                List<Integer> newValues = new ArrayList<>();
                for (int oldValue : set) {
                    if (oldValue < value) {
                        newValues.add(oldValue + value);
                    } else {
                        break;
                    }
                }
                set.addAll(newValues);
                set.add(value);
            }
            return set.pollLast();
        }
    }

}
