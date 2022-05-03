package leetcode.problems;

import java.util.*;

public class Test0937_重新排列日志文件 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));
        System.out.println(Arrays.toString(new Solution().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"})));
    }

    static class Solution {
        public String[] reorderLogFiles(String[] logs) {
            List<String> letterLogs = new ArrayList<>();
            List<String> digitLogs = new ArrayList<>();
            for (String log : logs) {
                String[] words = log.split(" ");
                char c = words[1].charAt(0);
                if (Character.isAlphabetic(c)) {
                    letterLogs.add(log);
                } else if (Character.isDigit(c)) {
                    digitLogs.add(log);
                }
            }
            letterLogs.sort((log1, log2) -> {
                String subLog1 = log1.substring(log1.indexOf(" ") + 1);
                String subLog2 = log2.substring(log2.indexOf(" ") + 1);
                if (subLog1.equals(subLog2)) {
                    return log1.substring(0, log1.indexOf(" ")).compareTo(log2.substring(0, log2.indexOf(" ")));
                }
                return subLog1.compareTo(subLog2);
            });
            List<String> resLogs = new ArrayList<>(letterLogs);
            resLogs.addAll(digitLogs);
            String[] res = new String[logs.length];
            for (int i = 0; i < resLogs.size(); i++) {
                res[i] = resLogs.get(i);
            }
            return res;
        }
    }

}
