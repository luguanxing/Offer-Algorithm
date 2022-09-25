package leetcode.contest.week312;

import java.util.ArrayList;
import java.util.List;

public class Test6190_找到所有好下标 {

    public static void main(String[] args) {
        System.out.println(new Solution().goodIndices(
                new int[]{2, 1, 1, 1, 3, 4, 1},
                2
        ));
        System.out.println(new Solution().goodIndices(
                new int[]{2, 1, 1, 2},
                2
        ));
        System.out.println(new Solution().goodIndices(
                new int[]{878724, 201541, 179099, 98437, 35765, 327555, 475851, 598885, 849470, 943442},
                4
        ));
        System.out.println(new Solution().goodIndices(
                new int[]{478184, 863008, 716977, 921182, 182844, 350527, 541165, 881224},
                1
        ));
    }

    static class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int len = nums.length;
            int[] prevNoAsc = new int[len];
            int[] postNoDes = new int[len];
            prevNoAsc[0] = 1;
            postNoDes[len - 1] = 1;
            int cnt = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i - 1] >= nums[i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                prevNoAsc[i] = cnt;
            }
            cnt = 1;
            for (int i = len - 1; i >= 1; i--) {
                if (nums[i - 1] <= nums[i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                postNoDes[i - 1] = cnt;
            }
            List<Integer> list = new ArrayList<>();
            for (int i = k; i < len - k; i++) {
                if (prevNoAsc[i - 1] >= k && postNoDes[i + 1] >= k) {
                    list.add(i);
                }
            }
            return list;
        }
    }

}
