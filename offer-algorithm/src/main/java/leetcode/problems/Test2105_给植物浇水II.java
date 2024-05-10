package leetcode.problems;

public class Test2105_给植物浇水II {

    public static void main(String[] args) {
        // plants = [2,2,3,3], capacityA = 5, capacityB = 5
        System.out.println(new Solution().minimumRefill(new int[]{2, 2, 3, 3}, 5, 5));
        // plants = [2,2,3,3], capacityA = 3, capacityB = 4
        System.out.println(new Solution().minimumRefill(new int[]{2, 2, 3, 3}, 3, 4));
        // plants = [5], capacityA = 10, capacityB = 8
        System.out.println(new Solution().minimumRefill(new int[]{5}, 10, 8));
        System.out.println(new Solution().minimumRefill(new int[]{2,1,1}, 2, 2));
    }

    static class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int alice = capacityA;
            int bob = capacityB;
            int l = 0;
            int r = plants.length - 1;
            int res = 0;
            while (l <= r) {
                if (l == r) {
                    if (alice < plants[l] && bob < plants[l]) {
                        res++;
                    }
                    break;
                }
                if (alice < plants[l]) {
                    alice = capacityA;
                    res++;
                }
                alice -= plants[l++];
                if (bob < plants[r]) {
                    bob = capacityB;
                    res++;
                }
                bob -= plants[r--];
            }
            return res;
        }
    }

}
