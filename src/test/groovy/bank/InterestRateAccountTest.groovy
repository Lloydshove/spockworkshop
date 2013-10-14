package bank

import spock.lang.Specification
import spock.lang.Unroll

class InterestRateAccountTest extends Specification {

    // Data Driven Testing

    // 1 - write a test for interest calculation
    def "interest rates are calculated as expected"() {
        given: "an account"
        def account = new InterestRateAccount("1234", 100, 0.01)

        when:
        account = account.addMonthsOfInterest(12)

        then:
        account.balance() == 101
    }

    // 2 - Make it into a parameterized test testing multiple cases
    def "interest rates are calculated as expected for many cases"() {
        given: "an account"
        def account = new InterestRateAccount("1234", initialBalance, interestRate)

        when:
        account = account.addMonthsOfInterest(numberOfMonths)

        then:
        account.balance() == expected

        where:
        initialBalance << [100, 200, 300]
        interestRate << [0.01, 0.02, 0.03]
        numberOfMonths << [12, 12, 12]

        expected << [101, 204, 309]
    }

    // 3 - use those parameters to make the test name more readable so that when it fails its obvious
    // the values used ( don't forget to @Unroll )

    @Unroll
    def "starting balance #initialBalance with rate #interestRate for #numberOfMonths"() {
        given: "an account"
        def account = new InterestRateAccount("1234", initialBalance, interestRate)

        when:
        account = account.addMonthsOfInterest(numberOfMonths)

        then:
        account.balance() == expected

        where:
        initialBalance | interestRate | numberOfMonths || expected
        100            | 0.01         | 12             || 101
        200            | 0.02         | 12             || 204
        300            | 0.03         | 12             || 309
    }

    // 4 - try different styles of parameterization
    //      - Data tables
    //      - Data pipes
    //      - Data variabls  (not great for different values per test run)


}
