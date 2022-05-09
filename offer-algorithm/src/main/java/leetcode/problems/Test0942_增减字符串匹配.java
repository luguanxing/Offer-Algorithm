package leetcode.problems;

import java.util.Arrays;
import java.util.TreeSet;

public class Test0942_增减字符串匹配 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().diStringMatch("IDID")));
        System.out.println(Arrays.toString(new Solution().diStringMatch("III")));
        System.out.println(Arrays.toString(new Solution().diStringMatch("DDI")));
    }

    static class Solution {
        public int[] diStringMatch(String s) {
            int len = s.length();
            int cntI = 0;
            int cntD = 0;
            for (char c : s.toCharArray()) {
                if (c == 'I') {
                    cntI++;
                } else if (c == 'D') {
                    cntD++;
                }
            }
            // 至少要减少cntD次，至少要增加cntI次
            int[] res = new int[len + 1];
            int init = cntD;
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i <= len; i++) {
                set.add(i);
            }
            // 不断找下一个符合条件的数进行填充
            res[0] = init;
            set.remove(init);
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                int next = -1;
                if (c == 'I') {
                    next = set.higher(init);
                } else if (c == 'D') {
                    next = set.lower(init);
                }
                set.remove(next);
                res[i + 1] = next;
            }
            return res;
        }
    }

}
