package leetcode.contest.week380;

import java.util.*;

public class Test100207_找出数组中的美丽下标II {

    public static void main(String[] args) {
        // s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15
        System.out.println(new Solution().beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
        // s = "abcd""a", b = "a", k = 4
        System.out.println(new Solution().beautifulIndices("abcd", "a", "a", 4));
        // s = "dc", a = "dreec", b = "dc", k = 2
        System.out.println(new Solution().beautifulIndices("dc", "dreec", "dc", 2));
    }

    static class Solution {
        public List<Integer> beautifulIndices(String s, String a, String b, int k) {
            // 如果a或b比s长，则直接返回空列表
            if (a.length() > s.length() || b.length() > s.length()) {
                return new ArrayList<>();
            }
            List<Integer> aIndices = KMP(s, a);
            List<Integer> bIndices = KMP(s, b);
            List<Integer> result = new ArrayList<>();
            for (int ai : aIndices) {
                if (binarySearchClosest(bIndices, ai, k)) {
                    result.add(ai);
                }
            }
            return result;
        }

        private boolean binarySearchClosest(List<Integer> bIndices, int ai, int k) {
            int left = 0, right = bIndices.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (Math.abs(bIndices.get(mid) - ai) <= k) {
                    return true;
                } else if (bIndices.get(mid) < ai) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }

        private List<Integer> KMP(String s, String pat) {
            List<Integer> indices = new ArrayList<>();
            int[] lps = computeLPSArray(pat);
            int i = 0;
            int j = 0;
            while (i < s.length()) {
                if (pat.charAt(j) == s.charAt(i)) {
                    j++;
                    i++;
                }
                if (j == pat.length()) {
                    indices.add(i - j);
                    j = lps[j - 1];
                } else if (i < s.length() && pat.charAt(j) != s.charAt(i)) {
                    if (j != 0)
                        j = lps[j - 1];
                    else
                        i = i + 1;
                }
            }
            return indices;
        }

        private int[] computeLPSArray(String pat) {
            int len = 0;
            int i = 1;
            int[] lps = new int[pat.length()];
            lps[0] = 0;
            while (i < pat.length()) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                } else {
                    if (len != 0) {
                        len = lps[len - 1];
                    } else {
                        lps[i] = len;
                        i++;
                    }
                }
            }
            return lps;
        }
    }
}
