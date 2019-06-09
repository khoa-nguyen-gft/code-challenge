public class App {
    public static void main(String[] arg) {
        BankAccount bankAccount = new BankAccount.Builder(1L).withOwner("Marge").withBalance(20).build();

        System.out.println(bankAccount.toString());

    }
}

class BankAccount {
    private long accountNumber; // This is important, so we'll pass it to the constructor.
    private String owner;
    private double balance;

    private BankAccount() {
        // Constructor is now private.
    }

    public static class Builder {
        private long accountNumber; // This is important, so we'll pass it to the constructor.
        private String owner;
        private double balance;

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

        public BankAccount build() {
            BankAccount bankAccount = new BankAccount();
            bankAccount.accountNumber = this.accountNumber;
            bankAccount.owner = this.owner;
            bankAccount.balance = this.balance;

            return bankAccount;
        }
    }

    @Override
    public String toString() {
        return "BankAccount [accountNumber=" + accountNumber + ", owner=" + owner + ", balance=" + balance + "]";
    }

}