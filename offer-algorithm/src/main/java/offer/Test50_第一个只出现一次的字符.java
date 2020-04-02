package offer;

public class Test50_第一个只出现一次的字符 {

    public static void main(String[] args) {
        System.out.println(new Solution().FirstNotRepeatingChar("aaabbckkii"));
        System.out.println(new Solution().FirstNotRepeatingChar("google"));
    }

    static class Solution {
        public int FirstNotRepeatingChar(String str) {
            if (str == null) {
                return 0;
            }
            int[] chatTimes = new int[256];
            for (char c : str.toCharArray()) {
                chatTimes[c]++;
            }
            for (char c : str.toCharArray()) {
                // 首个出现次数为1的字符
                if (chatTimes[c] == 1) {
                    return str.indexOf(c);
                }
            }
            return -1;
        }
    }

}
