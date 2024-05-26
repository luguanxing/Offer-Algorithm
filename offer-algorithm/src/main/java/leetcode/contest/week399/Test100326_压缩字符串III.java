package leetcode.contest.week399;

public class Test100326_压缩字符串III {

    public static void main(String[] args) {
        System.out.println(new Solution().compressedString("abcde"));
        System.out.println(new Solution().compressedString("aaaaaaaaaaaaaabb"));
    }

    static class Solution {
        public String compressedString(String word) {
            StringBuilder sb = new StringBuilder();
            char last = word.charAt(0);
            int cnt = 1;
            for (int i = 1; i < word.length(); i++) {
                char current = word.charAt(i);
                if (current != last) {
                    sb.append(cnt);
                    sb.append(last);
                    last = current;
                    cnt = 1;
                    continue;
                }
                cnt++;
                if (cnt == 10) {
                    sb.append("9");
                    sb.append(last);
                    cnt = 1;
                }
            }
            sb.append(cnt);
            sb.append(last);
            return sb.toString();
        }
    }

}
