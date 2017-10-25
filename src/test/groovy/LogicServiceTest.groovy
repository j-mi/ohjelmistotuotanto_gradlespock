import spock.lang.Specification
import spock.lang.Unroll

class LogicServiceTest  extends Specification {

    def "First input is correctly identified as bigger"() {
        setup: "given a logicservice instance"
        LogicService ls = new LogicService()

        expect: "the first number should not be bigger"
        ls.isFirstNumberBigger(1, 2) == false
        ls.isFirstNumberBigger(-1, 1) == false
        ls.isFirstNumberBigger(2, 1) == true
        ls.isFirstNumberBigger(1, 2) == false

    }

    def "Multiple inputs with bigger than should work also"() {
        setup: "given a logicservice instance"
        LogicService ls = new LogicService()

        expect:
        ls.isFirstNumberBigger(a, b) == c

        where:
        a | b || c
        1 | 0 || true
        2 | 3 || false
        1 | 1 || false
    }

    def "piping test data"() {
        setup: "given a logicservice instance"
        LogicService ls = new LogicService()

        expect: "the first number should be bigger if $a is bigger than $b"
        ls.isFirstNumberBigger(a, b) == c

        where:
        a << [1,2,3,4,5]
        b << [2,3,4,5,6]
        c << [false, false, false, false, false]
    }

    @Unroll
    def "data piping again, this time unrolled, check if first is bigger with #a is #b"() {
        setup:
        LogicService logicService = new LogicService()

        expect: "The logicservice should respond correctly"
        logicService.isFirstNumberBigger(a, b)==c

        where: "we give a lot of options"
        a << [1,2,3,4,5,6,7]
        b << [0,1,2,3,7,8,9]
        c << [true, true, true, true, false, false, false]
    }

}
