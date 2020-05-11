package leetcode.contest.week188;

public class Test1442_形成两个异或相等数组的三元组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countTriplets(new int[]{2, 3, 1, 6, 7}));
        System.out.println(new Solution().countTriplets(new int[]{1, 1, 1, 1, 1}));
        System.out.println(new Solution().countTriplets(new int[]{2, 3}));
        System.out.println(new Solution().countTriplets(new int[]{1, 3, 5, 7, 9}));
        System.out.println(new Solution().countTriplets(new int[]{7, 11, 12, 9, 5, 2, 7, 17, 22}));
    }

    static class Solution {
        public int countTriplets(int[] arr) {
            if (arr == null || arr.length == 1) {
                return 0;
            }
            // a==b即a^b==0，即只要[i,j]内区间所有数异或得到0，就能从区间中任选一个数把区间分成两半并且两个区间的异或结果相等
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int tmp = 0;
                    for (int k = i; k <= j; k++) {
                        tmp ^= arr[k];
                    }
                    if (tmp == 0) {
                        res += j - i;
                    }
                }
            }
            return res;
        }
    }

}
