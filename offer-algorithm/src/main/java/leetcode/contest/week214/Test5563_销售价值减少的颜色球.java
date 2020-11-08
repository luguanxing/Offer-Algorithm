package leetcode.contest.week214;

public class Test5563_销售价值减少的颜色球 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(
                new int[]{2, 5}, 4
        ));
        System.out.println(new Solution().maxProfit(
                new int[]{3, 5}, 6
        ));
        System.out.println(new Solution().maxProfit(
                new int[]{2, 8, 4, 10, 6}, 20
        ));
        System.out.println(new Solution().maxProfit(
                new int[]{1000000000}, 1000000000
        ));
        System.out.println(new Solution().maxProfit(
                new int[]{773160767}, 252264991
        ));
        System.out.println(new Solution().maxProfit(
                new int[]{497978859, 167261111, 483575207, 591815159}, 836556809
        ));
    }

    static class Solution {
        public int maxProfit(int[] inventory, int orders) {
            // 先用二分查找确定最低能卖出超过orders个数的价格
            int price = binarySearchLowestPrice(inventory, orders);
            // 再计算最终总额
            int profit = 0;
            for (int currentPrice : inventory) {
                if (currentPrice > price) {
                    // 等差求和从price到num
                    long sum = (long) (currentPrice + price) * (long) (currentPrice + 1 - price) / 2;
                    profit = (int) ((profit + sum) % 1000000007);
                    orders -= (currentPrice + 1 - price);
                }
            }
            // 最终剩下的orders，多还少补
            long last = orders * price % 1000000007;
            profit = (int) ((profit + last) % 1000000007);
            return profit;
        }

        private int binarySearchLowestPrice(int[] inventory, int orders) {
            int left = 0;
            int right = (int) 1e9;
            while (left < right) {
                int mid = right - (right - left) / 2;
                int sum = 0;
                for (int price : inventory) {
                    if (price > mid) {
                        sum += (price - mid);
                    }
                }
                if (sum < orders) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }
    }

}
