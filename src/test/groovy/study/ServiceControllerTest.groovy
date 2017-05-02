package study

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.restdocs.snippet.Snippet
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification
import study.hello.EmployeeData
import study.hello.EmployeeSet
import study.hello.ServiceController

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import static org.springframework.restdocs.operation.preprocess.Preprocessors.removeHeaders
import static org.springframework.restdocs.operation.preprocess.Preprocessors.removeHeaders
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.springframework.restdocs.payload.PayloadDocumentation.*

/**
 * @author alexey.markov@bostongene.com
 */
@WebMvcTest(ServiceController)
@AutoConfigureRestDocs("build/docs")
class ServiceControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @MockBean
    EmployeeSet employeeSet

    def "check add employee"(){
        expect:
        this.mockMvc.perform(get(addRequest()))
            .andExpect(status().isOk())
            .andDo(document("add-employee"))
    }

    def "check get employee"(){
        expect:
        this.mockMvc.perform(get(getRequest()))
                .andExpect(status().isOk())
                .andDo(document("get-employee"))
    }

    def "check delete employee"(){
        expect:
        this.mockMvc.perform(get(deleteRequest()))
                .andExpect(status().isOk())
                .andDo(document("delete-employee"))
    }

    static addRequest() {
        "/employee/add?name=Sam&lastName=Smith&email=smth@gmail.com&password=654321&date=22-04-1998"
    }

    static getRequest() {
        "/employee/get?email=smth@gmail.com"
    }

    static deleteRequest() {
        "/employee/delete?email=smth@gmail.com"
    }

    static restDocument(String methodName, Snippet... snippets)
    {
        document(methodName,
                preprocessRequest(prettyPrint(), removeHeaders("Host")),
                preprocessResponse(prettyPrint(), removeHeaders("X-Application-Context",
                        "X-Content-Type-Options", "X-XSS-Protection", "Cache-Control",
                        "Pragma", "Expires", "X-Frame-Options")),
                snippets)
    }
}
