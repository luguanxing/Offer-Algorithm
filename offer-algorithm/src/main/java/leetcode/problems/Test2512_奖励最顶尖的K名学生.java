package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test2512_奖励最顶尖的K名学生 {

    public static void main(String[] args) {
        System.out.println(new Solution().topStudents(
                new String[]{"smart", "brilliant", "studious"},
                new String[]{"not"},
                new String[]{"this student is studious", "the student is smart"},
                new int[]{1, 2},
                2
        ));
        System.out.println(new Solution().topStudents(
                new String[]{"smart", "brilliant", "studious"},
                new String[]{"not"},
                new String[]{"this student is not studious", "the student is smart"},
                new int[]{1, 2},
                2
        ));
    }

    static class Solution {
        public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
            Set<String> postitive = new HashSet<>();
            Set<String> negative = new HashSet<>();
            for (String pf : positive_feedback) {
                postitive.add(pf);
            }
            for (String nf : negative_feedback) {
                negative.add(nf);
            }
            List<int[]> studentScoreList = new ArrayList<>();
            for (int i = 0; i < report.length; i++) {
                String studentReport = report[i];
                int id = student_id[i];
                int score = 0;
                for (String word : studentReport.split(" ")) {
                    if (postitive.contains(word)) {
                        score += 3;
                    } else if (negative.contains(word)) {
                        score -= 1;
                    }
                }
                studentScoreList.add(new int[]{id, score});
            }
            Collections.sort(studentScoreList, (s1, s2) -> {
                if (s1[1] != s2[1]) {
                    return Integer.compare(s2[1], s1[1]);
                } else {
                    return Integer.compare(s1[0], s2[0]);
                }
            });
            return studentScoreList.subList(0, k).stream().map(s -> s[0]).collect(Collectors.toList());
        }
    }

}
