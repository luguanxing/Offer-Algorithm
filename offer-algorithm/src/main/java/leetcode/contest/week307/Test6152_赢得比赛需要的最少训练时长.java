package leetcode.contest.week307;

public class Test6152_赢得比赛需要的最少训练时长 {

    public static void main(String[] args) {
        System.out.println(new Solution().minNumberOfHours(
                5,
                3,
                new int[]{1, 4, 3, 2},
                new int[]{2, 6, 3, 1}
        ));
        System.out.println(new Solution().minNumberOfHours(
                2,
                4,
                new int[]{1},
                new int[]{3}
        ));
        System.out.println(new Solution().minNumberOfHours(
                1,
                1,
                new int[]{1, 1, 1, 1},
                new int[]{1, 1, 1, 50}
        ));
    }

    static class Solution {
        public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int needEnergy = 0;
            int needExperience = 0;
            for (int i = 0; i < energy.length; i++) {
                int eng = energy[i];
                int exp = experience[i];
                if (initialEnergy <= eng) {
                    needEnergy += (eng - initialEnergy) + 1;
                    initialEnergy += (eng - initialEnergy) + 1;
                }
                initialEnergy -= eng;
                if (initialExperience <= exp) {
                    needExperience = Math.max(needExperience, (exp - initialExperience) + 1);
                }
                initialExperience += exp;
            }
            return needEnergy + needExperience;
        }
    }

}
