package bank;

public class InterestRateAccount implements Account<InterestRateAccount>{

    private final BasicAccount basicAccount;
    private final double interestRate;

    public InterestRateAccount(String accountNumber, double balance, double interestRate){
        this.interestRate = interestRate;
        this.basicAccount = new BasicAccount(accountNumber, balance);
    }

    @Override
    public InterestRateAccount deposit(double deposit){
        return new InterestRateAccount(basicAccount.accountNumber(), basicAccount.balance() + deposit, interestRate);
    }

    public InterestRateAccount addMonthsOfInterest(int numberOfMonths){
        double interest = basicAccount.balance() * (interestRate/12d) * numberOfMonths;
        return deposit(interest);
    }

    @Override
    public double balance() {
        return basicAccount.balance();
    }

    @Override
    public String accountNumber() {
        return basicAccount.accountNumber();
    }

}
