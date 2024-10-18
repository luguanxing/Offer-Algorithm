package leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test3191_使二进制数组全部等于1的最少操作次数I {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(new Solution().minOperations(new int[]{0, 1, 1, 1}));
        System.out.println(new Solution().minOperations(new int[]{1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1}));
    }

    static class Solution {
        public int minOperations(int[] nums) {
            StringBuilder sb = new StringBuilder(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining()));
            int cnt = 0;
            while (sb.length() >= 3) {
                String prefix = sb.substring(0, 3);
                sb = sb.delete(0, 3);
                switch (prefix) {
                    case "000":
                        cnt++;
                        break;
                    case "111":
                        break;
                    case "001":
                        cnt++;
                        sb.insert(0, "0");
                        break;
                    case "110":
                        sb.insert(0, "0");
                        break;
                    case "010":
                        cnt++;
                        sb.insert(0, "01");
                        break;
                    case "101":
                        sb.insert(0, "01");
                        break;
                    case "011":
                        cnt++;
                        sb.insert(0, "00");
                        break;
                    case "100":
                        sb.insert(0, "00");
                        break;
                    default:
                        break;
                }
            }
            if (sb.length() > 0 && !sb.toString().equals("11")  && !sb.toString().equals("1")) {
                return -1;
            }
            return cnt;
        }
    }

}
