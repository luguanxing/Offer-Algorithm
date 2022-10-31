package leetcode.problems;

public class Test0481_神奇字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().magicalString(6));
        System.out.println(new Solution().magicalString(1));
    }

    static class Solution {
        public int magicalString(int n) {
            // 从"12"开始构造直到长度超过n
            StringBuilder sb = new StringBuilder("12");
            while (sb.length() < n) {
                sb = extend(sb);
            }
            // 统计结果并返回
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sb.charAt(i) == '1') {
                    cnt++;
                }
            }
            return cnt;
        }

        private StringBuilder extend(StringBuilder sb) {
            StringBuilder newSb = new StringBuilder();
            boolean is1 = true;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                int cnt = 0;
                if (c == '1') {
                    cnt = 1;
                } else if (c == '2') {
                    cnt = 2;
                }
                for (int j = 1; j <= cnt; j++) {
                    newSb = newSb.append(is1 ? '1' : '2');
                }
                is1 = !is1;
            }
            return newSb;
        }
    }

}
