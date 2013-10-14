package bank

import spock.lang.Specification
import spock.lang.Unroll

class MarketRateAccountTest extends Specification {




    // Interaction based testing

    // 1 - Write some parameterized tests for this, you can't do them without mocking.  So do that!
    @Unroll
    def "when market rate is #marketRate the balance with interest is calculated correctly"() {
        RateSource mockRate = Mock()

        when: "I calculate balance after #months"
        def account = new MarketRateAccount("0001", initialBalance, mockRate)
        account = account.addMonthsOfInterest(months)

        then:
        account.balance() == expected
        1 * _ >> marketRate

        where:
        initialBalance | marketRate | months || expected
        100            | 0.01       | 12     || 101
        200            | 0.02       | 12     || 204
        300            | 0.03       | 12     || 309

    }


}
