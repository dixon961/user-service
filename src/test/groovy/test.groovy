import study.hello.Employee
import spock.lang.*

import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeParseException

class EmployeeTests extends Specification {


    @Unroll
    def "create correct Employee"(){
        given:
        def employee = null

        when:
        employee = new Employee("Alex", "Markov", "a@b.com", "123", datein)

        then:
        noExceptionThrown()
        employee.birthDate == dateout

        where:
        datein       || dateout
        "21-02-1996" || LocalDate.of(1996, Month.FEBRUARY, 21)
        "01-02-1982" || LocalDate.of(1982, Month.FEBRUARY, 1)
        "11-11-2001" || LocalDate.of(2001, Month.NOVEMBER, 11)

    }

    @Unroll
    def "create employee with wrong date format"(){
        given:
        def employee = null

        when:
        employee = new Employee("Alex", "Markov", "a@b.com", "123", date)

        then:
        thrown(IllegalArgumentException)

        where:
        date << ["21.02.1996",  "21 02 1996",  "21 February 1996",  "1996 02 21"]

    }

    @Unroll
    def "create employee with wrong date"(){
        given:
        def employee = null

        when:
        employee = new Employee("Alex", "Markov", "a@b.com", "123", date)

        then:
        thrown(DateTimeParseException)

        where:
        date << ["33-02-1996",  "21-13-1996"]
    }


    def "create employee with wrong name"(){
        given:
        def employee = null;

        when:
        employee = new Employee("R2", "D2", "r2d2@sw.com", "222", "02-02-1993")

        then:
        thrown(IllegalArgumentException)
    }

    def "create employee with wrong email"(){
        given:
        def employee = null;

        when:
        employee = new Employee("Adam", "Hell", "ah.com", "123", "02-02-1993")

        then:
        thrown(IllegalArgumentException)
    }


}