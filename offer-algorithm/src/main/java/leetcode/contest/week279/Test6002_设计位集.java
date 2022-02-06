package leetcode.contest.week279;

import java.util.ArrayList;
import java.util.List;

public class Test6002_设计位集 {

    public static void main(String[] args) {
        Bitset bs = new Bitset(45);
        System.out.println(bs.all());
        bs.flip();
        bs.count();
        bs.all();
        System.out.println(bs.one());
    }

    static class Bitset {
        int len;
        int cnt;
        boolean isFlip;
        int[] list;

        public Bitset(int size) {
            len = size;
            cnt = 0;
            isFlip = true;
            list = new int[size];
        }

        public void fix(int idx) {
            if (isFlip) {
                if (list[idx] != 1) {
                    list[idx] = 1;
                    cnt++;
                }
            } else {
                if (list[idx] != 0) {
                    list[idx] = 0;
                    cnt--;
                }
            }
        }

        public void unfix(int idx) {
            if (isFlip) {
                if (list[idx] != 0) {
                    list[idx] = 0;
                    cnt--;
                }
            } else {
                if (list[idx] != 1) {
                    list[idx] = 1;
                    cnt++;
                }
            }
        }

        public void flip() {
            isFlip = !isFlip;
        }

        public boolean all() {
            if (isFlip) {
                return cnt == len;
            } else {
                return cnt == 0;
            }
        }

        public boolean one() {
            if (isFlip) {
                return cnt >= 1;
            } else {
                return cnt != len;
            }
        }

        public int count() {
            if (isFlip) {
                return cnt;
            } else {
                return len - cnt;
            }
        }

        public String toString() {
            StringBuilder res = new StringBuilder();
            for (int i : list) {
                if (isFlip) {
                    res.append(i);
                } else {
                    res.append(1 - i);
                }
            }
            return res.toString();
        }
    }


}
