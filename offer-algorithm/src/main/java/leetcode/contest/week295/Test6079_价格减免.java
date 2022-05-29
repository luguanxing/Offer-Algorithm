package leetcode.contest.week295;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6079_价格减免 {

    public static void main(String[] args) {
        System.out.println(new Solution().discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
        System.out.println(new Solution().discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
        System.out.println(new Solution().discountPrices("$76111 ab $6 $", 48));
        System.out.println(new Solution().discountPrices("duew$11mengf $8 $1", 7));
        System.out.println(new Solution().discountPrices("f32eir5f6hlmmtnlq$zno3zbl5pr26b1xmet6q3rjzs422zqzsezpgi4jqx3h0olb428pk95qndkfz8hereio$2ewx0cnqlvnb6nl$$8iny7t4aemhnqzz6971rnq7pha97e9lf16227j5l2033pnddk $3513024 $516863 $604 $9128265 $945728 $nbf 5az21pm0tj $", 26));
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
            try {
                Double.parseDouble(priceValue);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
    }

}
