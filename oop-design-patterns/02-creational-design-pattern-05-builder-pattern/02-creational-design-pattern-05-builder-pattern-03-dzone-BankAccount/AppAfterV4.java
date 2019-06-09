public class App {
    public static void main(String[] arg) {
        BankAccount bankAccount = new BankAccount.Builder(1L).withOwner("Marge").withBalance(20).build();

        BankAccount bankAccount2 = new BankAccount.Builder(1L).withOwner("Marge").withBalance(20).withInterestRate(40)
                .withBranch("Spring").build();

        System.out.println(bankAccount2.toString());

    }
}

class BankAccount {
    private long accountNumber; // This is important, so we'll pass it to the constructor.
    private String owner;
    private double balance;

    private String branch;
    private double interestRate;

    private BankAccount() {
        // Constructor is now private.
    }

    public static class Builder {
        private long accountNumber; // This is important, so we'll pass it to the constructor.
        private String owner;
        private double balance;

        private String branch;
        private double interestRate;

        public Builder(long accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder withBranch(String branch) {
            this.branch = branch;
            return this;
        }

        public Builder withInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountNumber = this.accountNumber;
            bankAccount.owner = this.owner;
            bankAccount.balance = this.balance;
            bankAccount.branch = this.branch;
            bankAccount.interestRate = this.interestRate;
            return bankAccount;
        }
    }

    @Override
    public String toString() {
        return "BankAccount [accountNumber=" + accountNumber + ", owner=" + owner + ", balance=" + balance + ", branch="
                + branch + ", interestRate=" + interestRate + "]";
    }

}