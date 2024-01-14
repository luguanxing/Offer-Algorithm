package leetcode.contest.week380;

import java.util.*;

public class Test100165_找出数组中的美丽下标I {

    public static void main(String[] args) {
        // s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15
        System.out.println(new Solution().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
        // s = "abcd", a = "a", b = "a", k = 4
        System.out.println(new Solution().beautifulIndices("abcd", "a", "a", 4));
    }

    static class Solution {
        public List<Integer> beautifulIndices(String s, String a, String b, int k) {
            List<Integer> aIndices = new ArrayList<>();
            List<Integer> bIndices = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            // 找到所有的a和b的出现位置
            for (int i = 0; i <= s.length() - a.length(); i++) {
                if (s.startsWith(a, i)) {
                    aIndices.add(i);
                }
            }
            for (int i = 0; i <= s.length() - b.length(); i++) {
                if (s.startsWith(b, i)) {
                    bIndices.add(i);
                }
            }

            // 计算美丽下标
            for (int ai : aIndices) {
                for (int bi : bIndices) {
                    if (Math.abs(ai - bi) <= k) {
                        result.add(ai);
                        break; // 只需找到一个符合条件的b即可
                    }
                }
            }

            return result;
        }
    }

}
