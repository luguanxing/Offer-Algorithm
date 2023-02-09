package leetcode.problems;

import java.util.*;

public class Test1797_设计一个验证系统 {

    public static void main(String[] args) {
//        AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
//        authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
//        authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
//        System.out.println(authenticationManager.countUnexpiredTokens(6)); // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
//        authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
//        authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
//        authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
//        System.out.println(authenticationManager.countUnexpiredTokens(15)); // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
        AuthenticationManager am = new AuthenticationManager(13);
        am.renew("ajvy", 1);
        System.out.println(am.countUnexpiredTokens(3));
        System.out.println(am.countUnexpiredTokens(4));
        am.generate("fuzxq", 5);
        am.generate("izmry", 7);
        am.renew("puv", 12);
        am.generate("ybiqb", 13);
        am.generate("gm", 14);
        System.out.println(am.countUnexpiredTokens(15));
        System.out.println(am.countUnexpiredTokens(18));
        System.out.println(am.countUnexpiredTokens(19));
        am.renew("ybiqb", 21);
        System.out.println(am.countUnexpiredTokens(23));
        System.out.println(am.countUnexpiredTokens(25));
        System.out.println(am.countUnexpiredTokens(26));
        am.generate("aqdm", 28);
        System.out.println(am.countUnexpiredTokens(29));
        am.renew("puv", 30);
    }

    static class AuthenticationManager {
        Map<String, Set<Integer>> map;
        int ttl;

        public AuthenticationManager(int timeToLive) {
            this.map = new HashMap<>();
            this.ttl = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            Set<Integer> list = map.getOrDefault(tokenId, new TreeSet<>());
            list.add(currentTime);
            map.put(tokenId, list);
        }

        public void renew(String tokenId, int currentTime) {
            Set<Integer> list = map.getOrDefault(tokenId, new TreeSet<>());
            for (int time : list) {
                if (time < currentTime && currentTime < time + ttl) {
                    list.add(currentTime);
                    break;
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            int res = 0;
            for (Set<Integer> list : map.values()) {
                for (int time : list) {
                    if (time < currentTime && currentTime < time + ttl) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }


}
