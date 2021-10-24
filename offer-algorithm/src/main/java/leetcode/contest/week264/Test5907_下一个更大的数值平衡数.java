package leetcode.contest.week264;

public class Test5907_下一个更大的数值平衡数 {

    public static void main(String[] args) {
        System.out.println(new Solution().nextBeautifulNumber(1));
        System.out.println(new Solution().nextBeautifulNumber(1000));
        System.out.println(new Solution().nextBeautifulNumber(3000));
    }

    static class Solution {
        public int nextBeautifulNumber(int n) {
            for (int i = n + 1; i <= 2000000; i++) {
                String str = String.valueOf(i);
                int[] map = new int[10];
                for (char c : str.toCharArray()) {
                    map[c - '0']++;
                }
                boolean isOk = true;
                for (char c : str.toCharArray()) {
                    if (map[c - '0'] != c - '0') {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    return i;
                }
            }
            return 0;
        }
    }

}
