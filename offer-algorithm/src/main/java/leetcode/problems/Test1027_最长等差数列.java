package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Test1027_最长等差数列 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestArithSeqLength(new int[]{3, 6, 9, 12}));
        System.out.println(new Solution().longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(new Solution().longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));
        System.out.println(new Solution().longestArithSeqLength(new int[]{0, 8, 45, 88, 48, 68, 28, 55, 17, 24}));
    }

    static class Solution {
        public int longestArithSeqLength(int[] nums) {
            int len = nums.length;
            int res = 0;
            Map<Integer, TreeSet<Integer>> numIndexs = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int num = nums[i];
                TreeSet<Integer> set = numIndexs.getOrDefault(num, new TreeSet<>());
                set.add(i);
                numIndexs.put(num, set);
            }
            for (int i = 0; i < len; i++) {
                for (int diff = -500; diff <= 500; diff++) {
                    int idx = i;
                    int cnt = 1;
                    int nextNum = nums[i] + diff;
                    while (numIndexs.containsKey(nextNum)) {
                        TreeSet<Integer> indexs = numIndexs.get(nextNum);
                        if (indexs.higher(idx) != null) {
                            idx = indexs.higher(idx);
                            nextNum += diff;
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    res = Math.max(res, cnt);
                }
            }
            return res;
        }
    }

}
