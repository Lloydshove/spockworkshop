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


    // Redo the above test using the MAGIC spock old() feature.  Does it make this test better?
    // sometimes it does.  e.g. for cache hist, testing code that adds to/removes from lists etc....


    // 2 - Make it into a parameterized test testing multiple cases using data pipes <<
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

    // 3 - use  parameter names in the test to make it more readable
    //   - make each test parameter be expanded to its own test case
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



}
