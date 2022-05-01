package leetcode.contest.week291;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test6049_含最多K个可整除元素的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2));
        System.out.println(new Solution().countDistinct(new int[]{1, 2, 3, 4}, 4, 1));
    }

    static class Solution {
        public int countDistinct(int[] nums, int k, int p) {
            // 所有子数组
            int len = nums.length;
            Set<SubArray> subArrays = new HashSet<>();
            for (int size = 1; size <= len; size++) {
                for (int i = 0; i + size <= len; i++) {
                    int[] subNums = Arrays.copyOfRange(nums, i, i + size);
                    int divCnt = 0;
                    for (int num : subNums) {
                        if (num % p == 0) {
                            divCnt++;
                        }
                    }
                    subArrays.add(new SubArray(Arrays.toString(subNums), divCnt));
                }
            }
            int notOkCnt = 0;
            for (SubArray subArray : subArrays) {
                if (subArray.divCnt > k) {
                    notOkCnt++;
                }
            }
            return subArrays.size() - notOkCnt;
        }

        class SubArray {
            String str;
            int divCnt;

            public SubArray(String str, int divCnt) {
                this.str = str;
                this.divCnt = divCnt;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                SubArray subArray = (SubArray) o;
                return Objects.equals(str, subArray.str);
            }

            @Override
            public int hashCode() {
                return Objects.hash(str);
            }
        }
    }

}
