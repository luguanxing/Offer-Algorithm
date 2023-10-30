package leetcode.problems;

public class Test0275_H指数II {

    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(new Solution().hIndex(new int[]{1, 2, 100}));
        System.out.println(new Solution().hIndex(new int[]{0}));
        System.out.println(new Solution().hIndex(new int[]{100}));
        System.out.println(new Solution().hIndex(new int[]{1, 1}));
        System.out.println(new Solution().hIndex(new int[]{1, 2}));
        System.out.println(new Solution().hIndex(new int[]{11, 15}));
        System.out.println(new Solution().hIndex(new int[]{1, 2, 3, 7, 9}));

        System.out.println();

        System.out.println(new Solution2().hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(new Solution2().hIndex(new int[]{1, 2, 100}));
        System.out.println(new Solution2().hIndex(new int[]{0}));
        System.out.println(new Solution2().hIndex(new int[]{100}));
        System.out.println(new Solution2().hIndex(new int[]{1, 1}));
        System.out.println(new Solution2().hIndex(new int[]{1, 2}));
        System.out.println(new Solution2().hIndex(new int[]{11, 15}));
        System.out.println(new Solution2().hIndex(new int[]{1, 2, 3, 7, 9}));
    }

    static class Solution2 {
        public int hIndex(int[] citations) {
            int MAX_CITATION = 1005;
            int totalCitationCnt = 0;
            int[] citationCntMap = new int[MAX_CITATION];
            for (int citation : citations) {
                citationCntMap[citation]++;
                totalCitationCnt++;
            }
            int maxH = 0;
            for (int h = 0; h <= MAX_CITATION; h++) {
                int previousCnt = 0;
                for (int c = 0; c < MAX_CITATION; c++) {
                    if (c >= h && totalCitationCnt - previousCnt >= h) {
                        maxH = Math.max(maxH, h);
                        break;
                    }
                    previousCnt += citationCntMap[c];
                }
            }
            return maxH;
        }
    }

    static class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            int l = 0;
            int r = len - 1;
            // 二分枚举引用次数h
            while (l <= r) {
                int m = (l + r) / 2;
                if (citations[m] < len - m) {
                    // 满足条件，尝试找更大的h
                    l = m + 1;
                } else {
                    // 不满足条件，尝试找更小的h
                    r = m - 1;
                }
            }
            return len - l;
        }
    }

}
