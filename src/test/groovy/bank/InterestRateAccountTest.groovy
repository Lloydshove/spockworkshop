package bank

import spock.lang.Specification
import spock.lang.Unroll

class InterestRateAccountTest extends Specification {

    // Data Driven Testing

    // 1 - write a test for interest calculation
    def "interest rates are calculated as expected"() {

    }


    // Redo the above test using the MAGIC spock old() feature.  Does it make this test better?
    // sometimes it does.  e.g. for cache hist, testing code that adds to/removes from lists etc....


    // 2 - Make it into a parameterized test testing multiple cases using data pipes <<
    def "interest rates are calculated as expected for many cases"() {

    }

    // 3 - use  parameter names in the test to make it more readable
    //   - make each test parameter be expanded to its own test case
    def "starting balance #initialBalance with rate #interestRate for #numberOfMonths"() {

    }



}
