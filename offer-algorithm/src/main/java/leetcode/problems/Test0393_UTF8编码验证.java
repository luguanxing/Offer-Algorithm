package leetcode.problems;

public class Test0393_UTF8编码验证 {

    public static void main(String[] args) {
//        System.out.println(new Solution().validUtf8(new int[]{197, 130, 1}));
//        System.out.println(new Solution().validUtf8(new int[]{235, 140, 4}));
//        System.out.println(new Solution().validUtf8(new int[]{255}));
        System.out.println(new Solution().validUtf8(new int[]{39, 89, 227, 83, 132, 95, 10, 0}));
    }

    static class Solution {
        public boolean validUtf8(int[] data) {
            for (int i = 0; i < data.length; ) {
                int first = data[i];
                String firstStr = String.format("%08d", Integer.parseInt(Integer.toBinaryString(first)));
                if (firstStr.startsWith("0")) {
                    // 0开头
                    i += 1;
                } else {
                    // 1开头
                    if (firstStr.startsWith("110")) {
                        if (i + 1 >= data.length) {
                            return false;
                        }
                        String next1 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[i + 1])));
                        if (!next1.startsWith("10")) {
                            return false;
                        }
                        i += 2;
                    } else if (firstStr.startsWith("1110")) {
                        if (i + 2 >= data.length) {
                            return false;
                        }
                        String next1 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[i + 1])));
                        String next2 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[i + 2])));
                        if (!next1.startsWith("10") || !next2.startsWith("10")) {
                            return false;
                        }
                        i += 3;
                    } else if (firstStr.startsWith("11110")) {
                        if (i + 3 >= data.length) {
                            return false;
                        }
                        String next1 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[i + 1])));
                        String next2 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[i + 2])));
                        String next3 = String.format("%08d", Integer.parseInt(Integer.toBinaryString(data[i + 3])));
                        if (!next1.startsWith("10") || !next2.startsWith("10") || !next3.startsWith("10")) {
                            return false;
                        }
                        i += 4;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
