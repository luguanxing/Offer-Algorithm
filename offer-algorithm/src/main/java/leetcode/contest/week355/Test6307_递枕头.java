package leetcode.contest.week355;

public class Test6307_递枕头 {

    public static void main(String[] args) {
        System.out.println(new Solution().passThePillow(4, 1));
        System.out.println(new Solution().passThePillow(4, 2));
        System.out.println(new Solution().passThePillow(4, 3));
        System.out.println(new Solution().passThePillow(4, 4));
        System.out.println(new Solution().passThePillow(4, 5));
        System.out.println();
        System.out.println(new Solution().passThePillow(3, 1));
        System.out.println(new Solution().passThePillow(3, 2));
        System.out.println(new Solution().passThePillow(3, 3));
        System.out.println(new Solution().passThePillow(3, 4));
        System.out.println(new Solution().passThePillow(3, 5));
        System.out.println(new Solution().passThePillow(3, 6));
        System.out.println(new Solution().passThePillow(3, 7));
    }

    static class Solution {
        public int passThePillow(int n, int time) {
            boolean side = true;
            int pos = 1;
            while (time > n - 1) {
                if (side) {
                    pos = n;
                } else {
                    pos = 1;
                }
                time -= n - 1;
                side = !side;
            }
            return pos + (side ? time : -1 * time);
        }
    }

}
