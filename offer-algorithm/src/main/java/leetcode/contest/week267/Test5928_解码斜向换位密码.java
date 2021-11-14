package leetcode.contest.week267;

public class Test5928_解码斜向换位密码 {

    public static void main(String[] args) {
        System.out.println(new Solution().decodeCiphertext("ch   ie   pr", 3));
        System.out.println(new Solution().decodeCiphertext("iveo    eed   l te   olc", 4));
        System.out.println(new Solution().decodeCiphertext("coding", 1));
        System.out.println(new Solution().decodeCiphertext(" b  ac", 2));
        System.out.println(new Solution().decodeCiphertext("", 5));
    }

    static class Solution {
        public String decodeCiphertext(String encodedText, int rows) {
            int height = rows;
            int width = encodedText.length() / height;
            // 初始化矩阵
            char[][] matrix = new char[height][width];
            for (int i = 0; i < encodedText.length(); i++) {
                char c = encodedText.charAt(i);
                matrix[i / width][i % width] = c;
            }
            // 构造结果
            StringBuilder res = new StringBuilder();
            for (int col = 0; col < width; col++) {
                int y = 0;
                int x = col;
                while (y < height && x < width) {
                    res.append(matrix[y][x]);
                    y++;
                    x++;
                }
            }
            while (res.length() != 0 && res.charAt(res.length() - 1) == ' ') {
                res = res.deleteCharAt(res.length() - 1);
            }
            return res.toString();
        }
    }

}
