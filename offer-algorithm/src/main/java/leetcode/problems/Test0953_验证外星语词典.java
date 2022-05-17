package leetcode.problems;

public class Test0953_验证外星语词典 {

    public static void main(String[] args) {
        System.out.println(new Solution().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(new Solution().isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(new Solution().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    static class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] orderMap = new int[26];
            for (int i = 0; i < order.length(); i++) {
                orderMap[order.charAt(i) - 'a'] = i;
            }
            for (int i = 1; i < words.length; i++) {
                String lastWord = words[i - 1];
                String currentWord = words[i];
                if (currentWord.equals(lastWord) || currentWord.contains(lastWord)) {
                    continue;
                }
                if (lastWord.contains(currentWord) && lastWord.length() > currentWord.length()) {
                    return false;
                }
                for (int j = 0; j < Math.min(lastWord.length(), currentWord.length()); j++) {
                    int order1 = orderMap[lastWord.charAt(j) - 'a'];
                    int order2 = orderMap[currentWord.charAt(j) - 'a'];
                    if (order1 > order2) {
                        return false;
                    } if (order1 < order2) {
                        break;
                    }
                }
            }
            return true;
        }
    }

}
