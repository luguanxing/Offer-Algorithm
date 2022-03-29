package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test2024_考试的最大困扰度 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxConsecutiveAnswers("TTFF", 2));
        System.out.println(new Solution().maxConsecutiveAnswers("TFFT", 1));
        System.out.println(new Solution().maxConsecutiveAnswers("TTFTTFTT", 1));
        System.out.println(new Solution().maxConsecutiveAnswers("FFTFTTTFFF", 1));
    }

    static class Solution {
        public int maxConsecutiveAnswers(String answerKey, int k) {
            // 连续改k个F成T，看连续最长的T的个数
            int maxCntT = getMaxCnt(answerKey, k, 'T');
            // 连续改k个T成F，看连续最长的F的个数
            int maxCntF = getMaxCnt(answerKey, k, 'F');
            return Math.max(maxCntT, maxCntF);
        }

        private int getMaxCnt(String answerKey, int k, char targetChar) {
            List<Integer> diffIndexs = new ArrayList<>();
            for (int i = 0; i < answerKey.length(); i++) {
                if (answerKey.charAt(i) != targetChar) {
                    diffIndexs.add(i);
                }
            }
            if (diffIndexs.size() <= k) {
                return answerKey.length();
            }
            // 滑动窗口改掉连续的k个diffIndexs，看剩下最长片段的长度是多少
            int maxLen = 0;
            for (int i = 1; i < diffIndexs.size(); i++) {
                maxLen = Math.max(maxLen, diffIndexs.get(i) - diffIndexs.get(i - 1) - 1);
            }
            for (int i = 0; i <= diffIndexs.size() - k; i++) {
                int left = i == 0 ? -1 : diffIndexs.get(i - 1);
                int right = i + k == diffIndexs.size() ? answerKey.length() : diffIndexs.get(i + k);
                maxLen = Math.max(maxLen, right - left - 1);
            }
            return maxLen;
        }
    }

}
