package leetcode.contest.week372;

import java.util.ArrayList;
import java.util.List;

public class Test100122_区分黑球与白球 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSteps("101"));
        System.out.println(new Solution().minimumSteps("100"));
        System.out.println(new Solution().minimumSteps("0111"));
        System.out.println(new Solution().minimumSteps("11000111"));
        System.out.println(new Solution().minimumSteps("0100101"));
    }

    static class Solution {
        public long minimumSteps(String s) {
            int len = s.length();
            long res = 0;
            List<Integer> slots = new ArrayList<>();
            for (int i = len - 1; i >= 0; i--) {
                if (s.charAt(i) == '0') {
                    slots.add(0, i);
                } else {
                    if (slots.isEmpty()) {
                        continue;
                    } else {
                        int lastIdx = slots.get(slots.size() - 1);
                        res += lastIdx - i;
                        slots.remove(slots.size() - 1);
                        slots.add(0, i);
                    }
                }
            }
            return res;
        }
    }

}
