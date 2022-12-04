package leetcode.contest.week322;

import java.util.Arrays;

public class Test6254_划分技能点相等的团队 {

    public static void main(String[] args) {
        System.out.println(new Solution().dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
        System.out.println(new Solution().dividePlayers(new int[]{3, 4}));
        System.out.println(new Solution().dividePlayers(new int[]{1, 1, 2, 3}));
    }

    static class Solution {
        public long dividePlayers(int[] skill) {
            int len = skill.length;
            Arrays.sort(skill);
            int sum = skill[0] + skill[len - 1];
            long res = 0;
            for (int i = 0; i < len / 2; i++) {
                if (skill[i] + skill[len - 1 - i] != sum) {
                    return -1;
                }
                res += (long) skill[i] * skill[len - 1 - i];
            }
            return res;
        }
    }

}
