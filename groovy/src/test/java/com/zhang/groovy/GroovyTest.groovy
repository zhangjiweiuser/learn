package com.zhang.groovy

import spock.lang.Specification
import spock.lang.Unroll

class GroovyTest extends Specification {

    @Unroll
    def "computing the max num of two numbers,a=#a,b=#c,result=#c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b || c
        5 | 6 || 6
        3 | 1 || 3

    }
}
