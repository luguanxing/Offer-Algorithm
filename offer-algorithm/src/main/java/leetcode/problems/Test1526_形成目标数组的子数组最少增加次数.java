package leetcode.problems;

public class Test1526_形成目标数组的子数组最少增加次数 {

    public static void main(String[] args) {
        // target = [1,2,3,2,1]
        System.out.println(new Solution().minNumberOperations(new int[]{1, 2, 3, 2, 1}));
        // target = [3,1,1,2]
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 1, 2}));
        // target = [3,1,5,4,2]
        System.out.println(new Solution().minNumberOperations(new int[]{3, 1, 5, 4, 2}));
        // target = [1,1,1,1]
        System.out.println(new Solution().minNumberOperations(new int[]{1, 1, 1, 1}));
    }

    static class Solution {
        public int minNumberOperations(int[] target) {
            int res = target[0];
            // 使用prev记录之前最低的高度
            int prev = target[0];
            for (int i = 1; i < target.length; i++) {
                if (prev >= target[i]) {
                    // 之前的更新在这里能完全用上，只更新prev
                    prev = target[i];
                } else {
                    // 之前的更新不够用，需要增加
                    res += target[i] - prev;
                    prev = target[i];
                }
            }
            return res;
        }
    }

}
