package leetcode.problems;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Test0927_三等分 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{1, 0, 1, 0, 1})));
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{1, 1, 0, 1, 1})));
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{1, 1, 0, 0, 1})));
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0})));
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{1, 0, 1, 1, 0})));
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{0, 0, 0, 0, 0})));
        System.out.println(Arrays.toString(new Solution().threeEqualParts(new int[]{1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0})));
    }

    static class Solution {
        public int[] threeEqualParts(int[] arr) {
            int len = arr.length;
            int sum = Arrays.stream(arr).sum();
            if (sum % 3 != 0) {
                return new int[]{-1, -1};
            }
            if (sum == 0) {
                return new int[]{0, 2};
            }
            int partSum = sum / 3;
            String arrStr = Arrays.stream(arr).boxed().map(Object::toString).collect(Collectors.joining());

            // 先找到part1
            int idx1 = 0;
            int part1Sum = 0;
            for (int i = 0; i < len; i++) {
                part1Sum += arr[i];
                if (part1Sum == partSum) {
                    idx1 = i;
                    break;
                }
            }
            String part1 = arrStr.substring(0, idx1 + 1);

            // 向part1后枚举0同时再判断part2 & part3
            int idx2 = 0;
            int part2Sum = 0;
            for (int i = idx1 + 1; i < len; i++) {
                part2Sum += arr[i];
                if (part2Sum == partSum) {
                    idx2 = i + 1;
                    break;
                }
            }
            String part2 = arrStr.substring(idx1 + 1, idx2);
            String part3 = arrStr.substring(idx2);

            // 判断part1 & part2 & part3去掉头尾0是否相等
            while (part1.startsWith("0")) {
                part1 = part1.substring(1);
            }
            while (part1.endsWith("0")) {
                part1 = part1.substring(0, part1.length() - 1);
            }
            while (part2.startsWith("0")) {
                part2 = part2.substring(1);
            }
            while (part2.endsWith("0")) {
                part2 = part2.substring(0, part2.length() - 1);
            }
            while (part3.startsWith("0")) {
                part3 = part3.substring(1);
            }
            while (part3.endsWith("0")) {
                part3 = part3.substring(0, part3.length() - 1);
            }

            if (part1.equals(part2) && part2.equals(part3)) {
                int part3Sum = 0;
                int idx3;
                for (idx3 = arr.length - 1; idx3 >= 0; idx3--) {
                    part3Sum += arr[idx3];
                    if (part3Sum == partSum) {
                        break;
                    }
                }
                int partLen = arr.length - idx3;
                int firstIdx = arrStr.indexOf('1') + partLen - 1;
                int secondIndex = arrStr.indexOf('1', firstIdx + 1) + partLen;

                if (0 >= firstIdx + 1 || firstIdx + 1 >= secondIndex) {
                    return new int[]{-1, -1};
                }
                String first = arrStr.substring(0, firstIdx + 1);
                String sencond = arrStr.substring(firstIdx + 1, secondIndex);
                String third = arrStr.substring(secondIndex);
                if (new BigInteger(first, 2).equals(new BigInteger(sencond, 2)) && new BigInteger(sencond, 2).equals(new BigInteger(third, 2))) {
                    return new int[]{firstIdx, secondIndex};

                }
            }
            return new int[]{-1, -1};
        }
    }

    static class Solution_暴力 {
        public int[] threeEqualParts(int[] arr) {
            int len = arr.length;
            String arrStr = Arrays.stream(arr).boxed().map(Object::toString).collect(Collectors.joining());
            for (int i = 1; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    String part1 = arrStr.substring(0, i);
                    String part2 = arrStr.substring(i, j);
                    String part3 = arrStr.substring(j);
                    if (new BigInteger(part1, 2).equals(new BigInteger(part2, 2)) && new BigInteger(part2, 2).equals(new BigInteger(part3, 2))) {
                        return new int[]{i - 1, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }

}
