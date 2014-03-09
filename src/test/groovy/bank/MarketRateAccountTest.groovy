package bank

import spock.lang.Specification

class MarketRateAccountTest extends Specification {


    // write more data driven tests with some mocking (also called interaction based testing)
    // play around with the annotations available.  When would you use each?
    //                                           - Unroll
    //                                           - Timeout
    //                                           - Ignore(reason = xxx)
    //                                           - IgnoreRest
    //                                           - IgnoreIf
    //                                           - Requires
    //                                           - TypeChecked
    //                                           - Shared
    //                                           - Stepwise


    def "when market rate is #marketRate the balance with interest is #expected after #months months"() {
        RateSource mockRate = Mock()

        when: "I calculate balance after #months"
        def account = new MarketRateAccount("0001", initialBalance, mockRate)
        account = account.addMonthsOfInterest(months)

        then:
        account.balance() == expected
        1 * mockRate.getRate() >> marketRate

        where:
        initialBalance | marketRate | months || expected
        100            | 0.01       | 12     || 101
        200            | 0.02       | 12     || 204
        300            | 0.03       | 12     || 309
    }


}
