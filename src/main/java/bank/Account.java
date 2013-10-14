package bank;

public interface Account<A extends Account> {
    A deposit(double deposit);

    double balance();

    String accountNumber();
}
