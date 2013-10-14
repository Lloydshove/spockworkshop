import bank.BasicAccount;
import bank.InterestRateAccount;
import bank.MarketRateAccount;
import bank.RateSource;

public class Main {


    //instantiate classes to avoid 'unused' warnings
    public static void main(String[] args){
        new BasicAccount("whatever", 1234d).deposit(4567d).accountNumber();
        new BasicAccount("whatever", 1234d).deposit(4567d).balance();
        new InterestRateAccount("whatever", 1234d, 0.1).deposit(4567d).accountNumber(); //10% interest PA
        new InterestRateAccount("whatever", 1234d, 0.01).deposit(4567d).balance(); //1% interest PA
        new InterestRateAccount("whatever", 1234d, 0.01).deposit(4567d).addMonthsOfInterest(1); //1% interest PA
        new MarketRateAccount("whatever", 1234d, new RateSource()).deposit(4567d).balance();

        System.out.println(new RateSource().getRate());
    }

}
