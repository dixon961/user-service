import hello.Employee
import hello.EmployeeSet
import spock.lang.*

import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

class Test extends Specification {

    def "create correct Employee"(){
        given:
        def employee = null

        when:
        employee = new Employee("Alex", "Markov", "a@b.com", "123", "21-03-1996")

        then:
        noExceptionThrown()
        employee.birthDate == LocalDate.of(1996, Month.FEBRUARY, 21)

    }

    def "create employee with wrong date"(){
        given:
        def employee = null

        when:
        employee = new Employee("Alex", "Markov", "a@b.com", "123", "21.03.1996")

        then:
        thrown(IllegalArgumentException)
    }
}