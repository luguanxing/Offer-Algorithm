package leetcode.problems;

public class Test1405_最长快乐字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(1, 1, 7));
        System.out.println(new Solution().longestDiverseString(2, 2, 1));
        System.out.println(new Solution().longestDiverseString(7, 1, 0));
    }

    static class Solution {
        public String longestDiverseString(int a, int b, int c) {
            // 贪心，每次都尝试使用最多的字符进行拼接
            return find("", a, b, c);
        }

        private String find(String current, int aCnt, int bCnt, int cCnt) {
            if (aCnt == 0 && bCnt == 0 && cCnt == 0) {
                return current;
            }

            int maxCnt = Math.max(aCnt, Math.max(bCnt, cCnt));

            if (aCnt == maxCnt) {
                if (!current.endsWith("aa")) {
                    return find(current + "a", aCnt - 1, bCnt, cCnt);
                } else {
                    if (bCnt == cCnt && cCnt == 0) {
                        return current;
                    }
                    if (bCnt >= cCnt) {
                        return find(current + "b", aCnt, bCnt - 1, cCnt);
                    } else {
                        return find(current + "c", aCnt, bCnt, cCnt - 1);
                    }
                }
            }

            if (bCnt == maxCnt) {
                if (!current.endsWith("bb")) {
                    return find(current + "b", aCnt, bCnt - 1, cCnt);
                } else {
                    if (aCnt == cCnt && cCnt == 0) {
                        return current;
                    }
                    if (aCnt >= cCnt) {
                        return find(current + "a", aCnt - 1, bCnt, cCnt);
                    } else {
                        return find(current + "c", aCnt, bCnt, cCnt - 1);
                    }
                }
            }

            if (cCnt == maxCnt) {
                if (!current.endsWith("cc")) {
                    return find(current + "c", aCnt, bCnt, cCnt - 1);
                } else {
                    if (aCnt == bCnt && bCnt == 0) {
                        return current;
                    }
                    if (aCnt >= bCnt) {
                        return find(current + "a", aCnt - 1, bCnt, cCnt);
                    } else {
                        return find(current + "b", aCnt, bCnt - 1, cCnt);
                    }
                }
            }

            return current;
        }
    }

}
