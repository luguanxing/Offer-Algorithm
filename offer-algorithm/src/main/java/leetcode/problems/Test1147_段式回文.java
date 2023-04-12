package leetcode.problems;

public class Test1147_段式回文 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(new Solution().longestDecomposition("merchant"));
        System.out.println(new Solution().longestDecomposition("antaprezatepzapreanta"));
        System.out.println(new Solution().longestDecomposition("elvtoelvto"));
    }

    static class Solution {
        public int longestDecomposition(String text) {
            int res = 0;
            while (text.length() > 0) {
                int idx = 1;
                boolean isMatch = false;
                for (; idx + idx <= text.length(); idx++) {
                    String prefix = text.substring(0, idx);
                    String suffix = text.substring(text.length() - idx);
                    if (prefix.equals(suffix)) {
                        isMatch = true;
                        break;
                    }
                }
                if (isMatch) {
                    res += 2;
                    text = text.substring(idx, text.length() - idx);
                } else {
                    res++;
                    break;
                }
            }
            return res;
        }
    }

}
