package leetcode.problems;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test0676_实现一个魔法字典 {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // 返回 False
        System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        System.out.println(magicDictionary.search("hell")); // 返回 False
        System.out.println(magicDictionary.search("leetcoded")); // 返回 False
    }

    static class MagicDictionary {
        private Set<String> set;

        public MagicDictionary() {
        }

        public void buildDict(String[] dictionary) {
            set = Stream.of(dictionary).collect(Collectors.toSet());
        }

        public boolean search(String searchWord) {
            for (String word : set) {
                if (canTransfer(word, searchWord)) {
                    return true;
                }
            }
            return false;
        }

        private boolean canTransfer(String word, String searchWord) {
            if (word.length() != searchWord.length()) {
                return false;
            }
            int diffCnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diffCnt++;
                }
            }
            if (diffCnt != 1) {
                return false;
            }
            return true;
        }
    }


}
