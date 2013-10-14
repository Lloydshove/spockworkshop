package bank;

import java.util.Random;

public class RateSource {
    public double getRate() {
        return new Random().nextDouble()*0.10;  // anything between 0 and 0.10
    }
}
