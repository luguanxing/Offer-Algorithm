package leetcode.contest.week326;

public class Test6196_将字符串分割成值不超过K的子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPartition("165462", 60));
        System.out.println(new Solution().minimumPartition("238182", 5));
        System.out.println(new Solution().minimumPartition("1829727651", 10));
    }

    static class Solution {
        public int minimumPartition(String s, int k) {
            String kStr = Integer.toString(k);
            int kLen = kStr.length();
            int res = 0;
            while (!s.isEmpty()) {
                boolean isMatch = false;
                for (int i = kLen; i >= 1; i--) {
                    String prefix = s.substring(0, Math.min(i, s.length()));
                    if (k >= Integer.parseInt(prefix)) {
                        s = s.substring(Math.min(i, s.length()));
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    return -1;
                }
                res++;
            }
            return res;
        }
    }

}
