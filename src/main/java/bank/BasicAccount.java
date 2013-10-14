package bank;

public class BasicAccount implements Account{

    private final double balance;
    private final String accountNumber;

    public BasicAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public BasicAccount deposit(double deposit){
        return new BasicAccount(accountNumber, balance + deposit);
    }

    @Override
    public double balance() {
        return balance;
    }

    @Override
    public String accountNumber() {
        return accountNumber;
    }
}
