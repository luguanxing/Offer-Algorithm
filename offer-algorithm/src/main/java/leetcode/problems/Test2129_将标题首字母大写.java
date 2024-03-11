package leetcode.problems;

public class Test2129_将标题首字母大写 {

    public static void main(String[] args) {
        System.out.println(new Solution().capitalizeTitle("capiTalIze tHe titLe"));
        System.out.println(new Solution().capitalizeTitle("First leTTeR of EACH Word"));
        System.out.println(new Solution().capitalizeTitle("i lOve leetcode"));
    }

    static class Solution {
        public String capitalizeTitle(String title) {
            String[] words = title.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.length() >= 3) {
                    words[i] = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                } else {
                    words[i] = word.toLowerCase();
                }
            }
            return String.join(" ", words);
        }
    }

}
