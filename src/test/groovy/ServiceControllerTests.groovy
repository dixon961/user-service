import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import study.hello.Employee
import study.hello.ServiceController

/**
 * @author alexey.markov@bostongene.com
 */
class ServiceControllerTests extends Specification {
    @MockBean
    MockMvc mockMvc

    @MockBean
    ServiceController serviceController

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
