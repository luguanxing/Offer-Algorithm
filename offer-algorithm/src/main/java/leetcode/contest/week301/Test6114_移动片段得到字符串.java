package leetcode.contest.week301;

public class Test6114_移动片段得到字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().canChange("_L__R__R_", "L______RR"));
        System.out.println(new Solution().canChange("R_L_", "__LR"));
        System.out.println(new Solution().canChange("_R", "R_"));
        System.out.println(new Solution().canChange("_L_R_L_", "_L__RL_"));
        System.out.println(new Solution().canChange("_L_R_L_", "L___RL_"));
    }

    static class Solution {
        public boolean canChange(String start, String target) {
            if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
                return false;
            }
            // 双指针比对
            int len = target.length();
            int startIdx = 0;
            int targetIdx = 0;
            for (; targetIdx < len;) {
                // 忽略"_"的情况
                char targetChar = target.charAt(targetIdx);
                if (targetChar == '_') {
                    targetIdx++;
                    continue;
                }
                while (startIdx < len && start.charAt(startIdx) == '_') {
                    startIdx++;
                    continue;
                }
                char startChar = target.charAt(targetIdx);
                // 看看能否对得上
                if (startChar != targetChar) {
                    return false;
                }
                if (targetChar == 'L' && targetIdx > startIdx) {
                    return false;
                }
                if (targetChar == 'R' && targetIdx < startIdx) {
                    return false;
                }
                // 剩下能对上
                startIdx++;
                targetIdx++;
            }
            return true;
        }
    }

    static class Solution_暴力 {
        public boolean canChange(String start, String target) {
            // 先判断是否有跨越的情况
            if (!start.replaceAll("_", "").equals(target.replaceAll("_", ""))) {
                return false;
            }
            // 再判断
            return judge(new StringBuilder(start), new StringBuilder(target), 0);
        }

        private boolean judge(StringBuilder source, StringBuilder target, int lCnt) {
            if (source.length() == 0) {
                return true;
            }
            int len = source.length();
            char targetChar = target.charAt(len - 1);
            char sourceChar = source.charAt(len - 1);
            if (sourceChar != targetChar) {
                if (targetChar == '_') {
                    if (sourceChar == 'R') {
                        return false;
                    } else if (sourceChar == 'L') {
                        lCnt++;
                    }
                } else if (targetChar == 'R') {
                    int rIndex = -1;
                    for (int i = len - 1; i >= 0; i--) {
                        if (source.charAt(i) == 'R') {
                            rIndex = i;
                            break;
                        }
                    }
                    int lIndex = -1;
                    for (int i = len - 1; i >= 0; i--) {
                        if (source.charAt(i) == 'L') {
                            lIndex = i;
                            break;
                        }
                    }
                    if (lIndex >= rIndex) {
                        return false;
                    }
                    source.setCharAt(rIndex, '_');
                } else if (targetChar == 'L') {
                    if (lCnt <= 0) {
                        return false;
                    }
                    lCnt--;
                }
            }
            return judge(source.deleteCharAt(len - 1), target.deleteCharAt(len - 1), lCnt);
        }
    }

}
