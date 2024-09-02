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
            // 滑动窗口，找到最大的T和F的连续片段
            int maxT = maxWindow(answerKey, k, 'T');
            int maxF = maxWindow(answerKey, k, 'F');
            return Math.max(maxT, maxF);
        }

        private int maxWindow(String answerKey, int k, char c) {
            int max = 0;
            int right = 0;
            int left = 0;
            int currentUnmatch = 0;
            while (right < answerKey.length()) {
                if (answerKey.charAt(right++) != c) {
                    currentUnmatch++;
                }
                while (currentUnmatch > k) {
                    if (answerKey.charAt(left++) != c) {
                        currentUnmatch--;
                    }
                }
                max = Math.max(max, right - left);
            }
            return max;
        }
    }

    static class Solution_OLD {
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
