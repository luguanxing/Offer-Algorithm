package leetcode.problems;

import java.util.*;

public class Test2353_设计食物评分系统 {

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );
        foodRatings.highestRated("korean"); // 返回 "kimchi"
        foodRatings.highestRated("japanese"); // 返回 "ramen"
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "sushi"
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "ramen"
    }

    static class FoodRatings {
        Map<String, TreeSet<FoodAndRate>> cusineDataMap = new HashMap<>();
        Map<String, FoodAndRate> foodInfoMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String food = foods[i];
                String cuisine = cuisines[i];
                int rate = ratings[i];
                if (!cusineDataMap.containsKey(cuisine)) {
                    cusineDataMap.put(cuisine, new TreeSet<>());
                }
                FoodAndRate foodAndRate = new FoodAndRate(cuisine, food, rate);
                cusineDataMap.get(cuisine).add(foodAndRate);
                foodInfoMap.put(food, foodAndRate);
            }
        }

        public void changeRating(String food, int newRating) {
            FoodAndRate foodAndRate = foodInfoMap.get(food);
            TreeSet<FoodAndRate> set = cusineDataMap.get(foodAndRate.cusine);
            if (set.contains(foodAndRate)) {
                set.remove(foodAndRate);
                foodAndRate.rate = newRating;
                set.add(foodAndRate);
            }
        }

        public String highestRated(String cuisine) {
            return cusineDataMap.get(cuisine).first().food;
        }

        class FoodAndRate implements Comparable<FoodAndRate> {
            String cusine;
            String food;
            int rate;

            public FoodAndRate(String cusine, String food, int rate) {
                this.cusine = cusine;
                this.food = food;
                this.rate = rate;
            }

            @Override
            public int compareTo(FoodAndRate o) {
                if (this.rate == o.rate) {
                    return this.food.compareTo(o.food);
                }
                return o.rate - this.rate;
            }
        }
    }


}
