public class App {
    public static void main() {
        BankAccount account = new BankAccount(123L, "Bart", 100.00);

    }
}

class BankAccount {
    private long accountNumber;
    private String owner;
    private double balance;

    public BankAccount(long accountNumber, String owner, double balance) {
        super();
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    }

  

    

    
    
