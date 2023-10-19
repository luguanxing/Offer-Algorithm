package leetcode.problems;

import java.util.*;

public class Test1726_同积元组 {

    public static void main(String[] args) {
        System.out.println(new Solution().tupleSameProduct(new int[]{2, 3, 4, 6}));
        System.out.println(new Solution().tupleSameProduct(new int[]{1, 2, 4, 5, 10}));
    }

    static class Solution {
        public int tupleSameProduct(int[] nums) {
            int len = nums.length;
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] == nums[j]) {
                        continue;
                    }
                    int product = nums[i] * nums[j];
                    List<int[]> coupleList = map.getOrDefault(product, new ArrayList<>());
                    int[] couple = {nums[i], nums[j]};
                    Arrays.sort(couple);
                    coupleList.add(couple);
                    map.put(product, coupleList);
                }
            }
            // 计算互不相等的个数
            int ans = 0;
            for (List<int[]> coupleList : map.values()) {
                int cLen = coupleList.size();
                for (int i = 0; i < cLen; i++) {
                    for (int j = 0; j < cLen; j++) {
                        if (i == j) {
                            continue;
                        }
                        if (coupleList.get(i)[0] == coupleList.get(j)[0] ||
                                coupleList.get(i)[1] == coupleList.get(j)[1] ||
                                coupleList.get(i)[0] == coupleList.get(j)[1] ||
                                coupleList.get(i)[1] == coupleList.get(j)[0]
                        ) {
                            continue;
                        }
                        ans += 4;
                    }
                }
            }
            return ans;
        }
    }

}
