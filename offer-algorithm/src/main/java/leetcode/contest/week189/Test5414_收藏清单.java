package leetcode.contest.week189;

import java.util.*;
import java.util.stream.Collectors;

public class Test5414_收藏清单 {

    public static void main(String[] args) {
        System.out.println(new Solution().peopleIndexes(
                Arrays.asList(
                        Arrays.asList("leetcode", "google", "facebook"),
                        Arrays.asList("google", "microsoft"),
                        Arrays.asList("google", "facebook"),
                        Arrays.asList("google"),
                        Arrays.asList("amazon")
                )
        ));
        System.out.println(new Solution().peopleIndexes(
                Arrays.asList(
                        Arrays.asList("leetcode", "google", "facebook"),
                        Arrays.asList("leetcode", "amazon"),
                        Arrays.asList("facebook", "google")
                )
        ));
        System.out.println(new Solution().peopleIndexes(
                Arrays.asList(
                        Arrays.asList("leetcode"),
                        Arrays.asList("google"),
                        Arrays.asList("facebook"),
                        Arrays.asList("amazon")
                )
        ));
        System.out.println(new Solution().peopleIndexes(
                Arrays.asList(
                        Arrays.asList("nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"),
                        Arrays.asList("nxaqhyoprhlhvhyojanr","ovqdyfqmlpxapbjwtssm","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty"),
                        Arrays.asList("ovqdyfqmlpxapbjwtssm","qmsbphxzmnvflrwyvxlc","udfuxjdxkxwqnqvgjjsp","yawoixzhsdkaaauramvg","zycidpyopumzgdpamnty")
                )
        ));
    }

    static class Solution {
        public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
            // 映射成关键字set的list
            List<Set<String>> keySetList = favoriteCompanies
                    .stream()
                    .map(list -> list.stream().collect(Collectors.toSet()))
                    .collect(Collectors.toList());
            // 判断关键字keySet每个key是否被其它otherKeySet完全包含，若被完全包含则结果中忽略
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < keySetList.size(); i++) {
                Set<String> keySet = keySetList.get(i);
                boolean isFullContained = false;
                for (int j = 0; j < keySetList.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    Set<String> otherKeySet = keySetList.get(j);
                    boolean containedByOther = true;
                    for (String key : keySet) {
                        if (!otherKeySet.contains(key)) {
                            containedByOther = false;
                            break;
                        }
                    }
                    if (containedByOther) {
                        // 找到被其他完全包含的，可以忽略了
                        isFullContained = true;
                        break;
                    }
                }
                if (!isFullContained) {
                    res.add(i);
                }
            }
            return res;
        }
    }

}
