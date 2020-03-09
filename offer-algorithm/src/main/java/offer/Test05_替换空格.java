package offer;

public class Test05_替换空格 {

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace(new StringBuffer("We Are Happy")));
        System.out.println(new Solution_非API版().replaceSpace(new StringBuffer("We Are Happy")));
    }

    static class Solution {
        public String replaceSpace(StringBuffer sb) {
            return sb.toString().replaceAll(" ", "%20");
        }
    }

    static class Solution_非API版 {
        public String replaceSpace(StringBuffer sb) {
            char[] chars = sb.toString().toCharArray();
            int spaceLen = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ' ') {
                    spaceLen++;
                }
            }
            char[] reChars = new char[chars.length + 2 * spaceLen];
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ' ') {
                    reChars[index++] = chars[i];
                } else {
                    reChars[index++] = '%';
                    reChars[index++] = '2';
                    reChars[index++] = '0';
                }
            }
            return new String(reChars);
        }
    }

}