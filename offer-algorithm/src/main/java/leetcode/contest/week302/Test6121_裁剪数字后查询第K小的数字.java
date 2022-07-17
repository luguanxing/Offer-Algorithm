package leetcode.contest.week302;

import java.util.*;
import java.util.stream.Collectors;

public class Test6121_裁剪数字后查询第K小的数字 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallestTrimmedNumbers(
                new String[]{"102", "473", "251", "814"},
                new int[][]{{1, 1}, {2, 3}, {4, 2}, {1, 2}}
        )));
        System.out.println(Arrays.toString(new Solution().smallestTrimmedNumbers(
                new String[]{"24", "37", "96", "04"},
                new int[][]{{2, 1}, {2, 2}}
        )));
    }

    static class Solution {
        public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int k = query[0];
                int trim = query[1];
                List<String> numList = Arrays
                        .stream(nums)
                        .collect(Collectors.toList());
                for (int j = 0; j < numList.size(); j++) {
                    String num = numList.get(j);
                    num = num.substring(num.length() - trim);
                    numList.set(j, num);
                }
                List<String> sortedNumList = new ArrayList<>(numList);
                Collections.sort(sortedNumList, String::compareTo);
                String kNum = sortedNumList.get(k - 1);
                int index = 0;
                for (String num : numList) {
                    if (num.equals(kNum)) {
                        continue;
                    }
                    if (num.compareTo(kNum) <= 0) {
                        index++;
                    }
                }
                for (int j = 0; j < numList.size(); j++) {
                    String num = numList.get(j);
                    if (!num.equals(kNum)) {
                        continue;
                    }
                    if (num.compareTo(kNum) <= 0) {
                        index++;
                    }
                    if (index == k) {
                        res[i] = j;
                        break;
                    }
                }
            }
            return res;
        }
    }

}
