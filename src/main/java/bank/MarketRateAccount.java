package bank;

public class MarketRateAccount implements Account<MarketRateAccount>{


    private final Account basicAccount;
    private RateSource rateSource;

    public MarketRateAccount(String accountNumber, double balance, RateSource rateSource){
        this.rateSource = rateSource;
        this.basicAccount = new BasicAccount(accountNumber, balance);
    }

    @Override
    public MarketRateAccount deposit(double deposit) {
        return new MarketRateAccount(
                basicAccount.accountNumber(),
                basicAccount.balance() + deposit,
                rateSource);
    }


    public MarketRateAccount addMonthsOfInterest(int numberOfMonths){
        double interest = basicAccount.balance() * (rateSource.getRate()/12d) * numberOfMonths;
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
