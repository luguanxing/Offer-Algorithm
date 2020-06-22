package leetcode.interview;

public class Test16_18_模式匹配 {

    public static void main(String[] args) {
        System.out.println(new Solution().patternMatching("abba", "dogcatcatdog"));
        System.out.println(new Solution().patternMatching("abba", "dogcatcatfish"));
        System.out.println(new Solution().patternMatching("aaaa", "dogcatcatdog"));
        System.out.println(new Solution().patternMatching("abba", "dogdogdogdog"));
        System.out.println(new Solution().patternMatching("", ""));
        System.out.println(new Solution().patternMatching("ab", ""));
        System.out.println(new Solution().patternMatching("a", ""));
        System.out.println(new Solution().patternMatching("bbb", "xxxxxx"));
        System.out.println(new Solution().patternMatching("bbba", "xxxxxxy"));
        System.out.println(new Solution().patternMatching("bbbbbbbbbabbbbbbbbabbbbbbbbbbaabbb", "mmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxbymbybximmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxbymbybximmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxmmbxuxbymbybximbymbybximmmbxuxmmbxuxmmbxux"));
    }

    static class Solution {
        public boolean patternMatching(String pattern, String value) {
            if (pattern.isEmpty() && value.isEmpty()) {
                return true;
            }
            // 计算a和b的个数
            int aNum = 0;
            int bNum = 0;
            for (int i = 0; i < pattern.length(); i++) {
                char c = pattern.charAt(i);
                if (c == 'a') {
                    aNum++;
                } else {
                    bNum++;
                }
            }
            if (value.isEmpty()) {
                if (aNum > 0 && bNum > 0) {
                    return false;
                } else {
                    return true;
                }
            }
            if (aNum == 1 || bNum == 1) {
                return true;
            }
            // 暴力枚举
            for (int aLen = 0; aLen < value.length(); aLen++) {
                for (int bLen = 0; bLen < value.length(); bLen++) {
                    if (aLen * aNum + bLen * bNum != value.length()) {
                        continue;
                    }
                    String aStr = "";
                    int aIndex = pattern.indexOf('a');
                    if (aIndex >= 0) {
                        aStr = value.substring(bLen * aIndex, bLen * aIndex + aLen);
                    }
                    String bStr = "";
                    int bIndex = pattern.indexOf('b');
                    if (bIndex >= 0) {
                        bStr = value.substring(aLen * bIndex, aLen * bIndex + bLen);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < pattern.length(); i++) {
                        if (pattern.charAt(i) == 'a') {
                            sb.append(aStr);
                        } else {
                            sb.append(bStr);
                        }
                    }
                    if (value.equals(sb.toString())) {
                        if (!aStr.equals(bStr)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

}
