package bank

import spock.lang.Specification


class BasicAccountTest extends Specification{

    // given when then
    // when then

    // expect where
    // given when then where


    def "should be constructed with the account number and balance specified"(){
        when : "construct a BasicAccount"
        def account = new BasicAccount("123456", 101.05d)

        then : "the account number is as expected"
        account.accountNumber() == "123456"
        account.balance() == 101.05d
    }

    def "should add balance to previous balance"(){
        given : "account has balance 100"
        def account = new BasicAccount("123456", 100d)

        when : "we add 50 to it"
        account = account.deposit 50

        then : "The balance is 150"
        account.accountNumber() == "123456"
        account.balance() == 150d
    }

}
