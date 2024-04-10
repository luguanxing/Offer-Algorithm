package leetcode.problems;

public class Test1702_修改后的最大二进制字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumBinaryString("000110"));
        System.out.println(new Solution().maximumBinaryString("01"));
        System.out.println(new Solution().maximumBinaryString("1100"));
    }

    static class Solution {
        public String maximumBinaryString(String binary) {
            char[] chars = binary.toCharArray();
            int len = chars.length;
            int l = 0;
            int r = len - 1;
            while (l < r) {
                // 当前为1不需要处理
                if (chars[l] == '1') {
                    l++;
                    continue;
                }
                // 当前为0需要处理
                if (l + 1 < r && chars[l + 1] == '0') {
                    // 出现00换成10
                    chars[l] = '1';
                    l++;
                } else {
                    // 出现01换成10，但需要找最后的0
                    while (r > l && chars[r] == '1') {
                        r--;
                    }
                    if (r > l) {
                        chars[l] = '1';
                        chars[r] = '1';
                        chars[l + 1] = '0';
                    }
                }
            }
            return new String(chars);
        }
    }

}
