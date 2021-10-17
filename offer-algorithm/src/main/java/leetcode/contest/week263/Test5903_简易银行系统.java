package leetcode.contest.week263;

public class Test5903_简易银行系统 {

    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(3, 10));
        System.out.println(bank.transfer(5, 1, 20));
        System.out.println(bank.deposit(5, 20));
        System.out.println(bank.transfer(3, 4, 15));
        System.out.println(bank.withdraw(10, 50));
    }

    static class Bank {
        long[] accounts;

        public Bank(long[] balance) {
            this.accounts = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 > accounts.length || account2 > accounts.length) {
                return false;
            }
            if (accounts[account1 - 1] < money) {
                return false;
            }
            accounts[account1 - 1] -= money;
            accounts[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account > accounts.length) {
                return false;
            }
            accounts[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account > accounts.length) {
                return false;
            }
            if (accounts[account - 1] < money) {
                return false;
            }
            accounts[account - 1] -= money;
            return true;
        }
    }

}
