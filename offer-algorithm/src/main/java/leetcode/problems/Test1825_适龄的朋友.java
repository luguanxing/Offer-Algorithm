package leetcode.problems;

public class Test1825_适龄的朋友 {

    public static void main(String[] args) {
        System.out.println(new Solution().numFriendRequests(new int[]{16, 16}));
        System.out.println(new Solution().numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(new Solution().numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }

    static class Solution {
        public int numFriendRequests(int[] ages) {
            // 统计分布
            int[] map = new int[256];
            for (int age : ages) {
                map[age]++;
            }
            int res = 0;
            for (int age1 = 1; age1 <= 120; age1++) {
                for (int age2 = 1; age2 <= 120; age2++) {
                    res += calculateRequests(age1, age2, map[age1], map[age2]);
                }
            }
            // 计算结果
            return res;
        }

        // 计算age2的人对于age1的人是否满足交友条件
        private int calculateRequests(int age1, int age2, int cnt1, int cnt2) {
            if (age2 <= age1 * 0.5 + 7 || age1 < age2) {
                return 0;
            }
            if (age1 == age2) {
                return cnt1 * (cnt1 - 1);
            }
            return cnt1 * cnt2;
        }
    }

}
