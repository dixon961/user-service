import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification
import study.hello.Employee
import study.hello.MongoData

/**
 * @author alexey.markov@bostongene.com
 */
class MongoDataTests extends Specification {

    MongoData mongoData = new MongoData()

    def "add correct employee to mongo"(){
        given:
        def employee = new Employee(
                name(),
                lastName(),
                email(),
                password(),
                birthDate()
        )

        when:
        this.mongoData.addEmployee(employee)

        then:
        this.mongoData.size() > 0
    }


    static name(){
        "Alex"
    }

    static lastName(){
        "Markov"
    }

    static email() {
        "dixon96143@gmail.com"
    }

    static password(){
        "12345678"
    }

    static birthDate(){
        "21-02-1996"
    }
}
