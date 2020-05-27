package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0974_和可被K整除的子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(new Solution().subarraysDivByK(new int[]{4, 5}, 5));
    }

    static class Solution {
        public int subarraysDivByK(int[] A, int K) {
            // (sum[j]-sum[i])%k==0即sum[j]%k==sum[i]%k==module，同余数量用map保存下来
            Map<Integer, Integer> sameModuleMap = new HashMap<>();
            int res = 0;
            int sum = 0;
            // 这里用sum优化了sum[A.length+1]数组，sum[i-j]=sum[j]-sum[i]，sum[0]=0
            sameModuleMap.put(sum, 1);
            for (int num : A) {
                sum += num;
                int module = (sum % K + K) % K;
                int sameModuleCnt = sameModuleMap.getOrDefault(module, 0);
                sameModuleMap.put(module, sameModuleCnt + 1);
                res += sameModuleCnt;
            }
            return res;
        }
    }

    static class Solution_ON2 {
        public int subarraysDivByK(int[] A, int K) {
            int res = 0;
            for (int left = 0; left < A.length; left++) {
                int sum = 0;
                for (int right = left; right < A.length; right++) {
                    sum += A[right];
                    if (sum % K == 0) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}

