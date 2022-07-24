package leetcode.contest.week303;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Test6126_设计食物评分系统 {

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );
        System.out.println(foodRatings.highestRated("korean")); // 返回 "kimchi"
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
        System.out.println(foodRatings.highestRated("japanese")); // 返回 "ramen"
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        System.out.println(foodRatings.highestRated("japanese")); // 返回 "sushi"
        // "sushi" 是分数最高的日式料理，评分为 16 。
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        System.out.println(foodRatings.highestRated("japanese")); // 返回 "ramen"
        // "sushi" 和 "ramen" 的评分都是 16 。
        // 但是，"ramen" 的字典序比 "sushi" 更小。
    }

    static class FoodRatings {
        Map<String, TreeSet<Food>> waySetMap;
        Map<String, Food> nameMap;

        public FoodRatings(String[] foods, String[] ways, int[] ratings) {
            waySetMap = new HashMap<>();
            nameMap = new HashMap<>();
            int len = foods.length;
            for (int i = 0; i < len; i++) {
                String foodName = foods[i];
                String way = ways[i];
                int rating = ratings[i];
                // 初始化信息
                Food food = new Food(foodName, way, rating);
                nameMap.put(foodName, food);
                TreeSet<Food> waySet = waySetMap.getOrDefault(way, new TreeSet<>());
                waySet.add(food);
                waySetMap.put(way, waySet);
            }
        }

        public void changeRating(String foodName, int newRating) {
            Food food = nameMap.get(foodName);
            if (food != null) {
                waySetMap.get(food.way).remove(food);
                food.score = newRating;
                waySetMap.get(food.way).add(food);
            }
        }

        public String highestRated(String way) {
            TreeSet<Food> waySet = waySetMap.get(way);
            for (Food food : waySet) {
                return food.name;
            }
            return null;
        }

        class Food implements Comparable<Food> {
            String name;
            String way;
            int score;

            public Food(String name, String way, int score) {
                this.name = name;
                this.way = way;
                this.score = score;
            }

            @Override
            public int compareTo(Food food) {
                if (this.score != food.score) {
                    return Integer.compare(food.score, this.score);
                }
                return this.name.compareTo(food.name);
            }

            @Override
            public String toString() {
                return "Food{" +
                        "name='" + name + '\'' +
                        ", way='" + way + '\'' +
                        ", score=" + score +
                        '}';
            }
        }
    }

}
