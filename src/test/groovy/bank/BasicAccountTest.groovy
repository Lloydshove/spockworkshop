package bank

import spock.lang.Specification


class BasicAccountTest extends Specification{

    //Docs: http://docs.spockframework.org/en/latest/


    // write some different non data-driven tests.

    // how will you split your test up to make it readable?
    
    //  e.g.
    //                        - given when then
    //                        - when then
    //                        - expect where
    //                        - given when then where

    // given == setup
    //         - sets up the feature to test
    //         - followed by and, expect, when, cleanup or where

    // when    - setup the stimulus to trigger the feature to be tested
    //         - followed always by then  (optionally can have an 'and' as well)
    // then    - describes an expected response
    //         - followed by and, expect, when, then, cleanup or where

    // expect  - more limited than a then block in that it may only contain conditions and variable definitions
    //         - helper for use with 'then' to do assertions with hamcrest matchers (then: expect: value, is matcher)
    //         - followed by and, when, cleanup or where

    // cleanup - clean up any resources here.  Always runs even if there was a previous exception
    //         - followed by where
    // where   - used to write data-driven features.  Always comes last in a method.
    //         - can only be followed by 'and'


    def "basic accounts should be constructed with the account number and balance specified"(){

    }

    def "should add balance to previous balance"(){

    }

    def 'should not allow negative starting balance and exception message should be exactly as expected'(){

    }

}
