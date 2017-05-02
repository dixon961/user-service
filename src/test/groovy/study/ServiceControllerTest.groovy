package study

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import study.hello.EmployeeData
import study.hello.ServiceController
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * @author alexey.markov@bostongene.com
 */
@WebMvcTest(ServiceController)
class ServiceControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @MockBean
    EmployeeData employeeData

    def "check add employee"(){
        expect:
        this.mockMvc.perform(get(addRequest())).andExpect(status().isOk())
    }

    def "check get employee"(){
        expect:
        this.mockMvc.perform(get(getRequest())).andExpect(status().isOk())
    }

    def "check delete employee"(){
        expect:
        this.mockMvc.perform(get(deleteRequest())).andExpect(status().isOk())
    }

    static addRequest() {
        "/employee/add?name=Egor&lastName=Markov&email=mrcov@gmail.com&password=654321&date=22-04-1998"
    }

    static getRequest() {
        "/employee/get?email=mrcov@gmail.com"
    }

    static deleteRequest() {
        "/employee/delete?email=mrcov@gmail.com"
    }
}
