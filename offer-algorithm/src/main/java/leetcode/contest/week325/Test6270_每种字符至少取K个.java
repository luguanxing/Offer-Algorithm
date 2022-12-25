package leetcode.contest.week325;

public class Test6270_每种字符至少取K个 {

    public static void main(String[] args) {
        System.out.println(new Solution().takeCharacters("aabaaaacaabc", 2));
        System.out.println(new Solution().takeCharacters("a", 1));
    }

    static class Solution {
        public int takeCharacters(String s, int k) {
            char[] chars = s.toCharArray();
            int[] cnt = new int[3];
            for (char c : chars) {
                if (c == 'a') {
                    cnt[0]++;
                } else if (c == 'b') {
                    cnt[1]++;
                } else {
                    cnt[2]++;
                }
            }
            if (cnt[0] < k || cnt[1] < k || cnt[2] < k) {
                return -1;
            }
            // 使用滑动窗口找中间最长的片段使a最多移除aCnt-k个， b最多移除bCnt-k个， c最多移除cCnt-k个
            int[] currentCnt = new int[3];
            int maxWindowSize = 0;
            int left = 0;
            int right = 0;
            while (left < chars.length) {
                // 如果右边未到尽头，不断先向右探测片段，如果大于目标sum-x则左边移动直到结束
                if (right < chars.length) {
                    currentCnt[chars[right++] - 'a']++;
                }
                while ((currentCnt[0] > cnt[0] - k || currentCnt[1] > cnt[1] - k || currentCnt[2] > cnt[2] - k) && left < chars.length) {
                    currentCnt[chars[left++] - 'a']--;
                }
                maxWindowSize = Math.max(maxWindowSize, right - left);
                if (right == chars.length) {
                    left++;
                }
            }
            return s.length() - maxWindowSize;
        }
    }
}
