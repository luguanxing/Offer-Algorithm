package leetcode.problems;

public class Test2288_价格减免 {

    public static void main(String[] args) {
        // sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
        System.out.println(new Solution().discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        // sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
        System.out.println(new Solution().discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
        System.out.println(new Solution().discountPrices("$2f", 50));
    }

    static class Solution {
        public String discountPrices(String sentence, int discount) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.startsWith("$")) {
                    String priceValue = word.substring(1);
                    if (!priceValue.isEmpty() && !priceValue.contains("$") && isDigit(priceValue)) {
                        double discountValue = Double.parseDouble(priceValue) * (1 - discount / 100.0);
                        words[i] = String.format("$%.2f", discountValue);
                    }
                }
            }
            return String.join(" ", words);
        }

        private boolean isDigit(String priceValue) {
            for (char c : priceValue.toCharArray()) {
                if (!Character.isDigit(c) && c != '.') {
                    return false;
                }
            }
            return true;
        }
    }

}
