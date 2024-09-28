package web


import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpStatus
import spock.lang.Specification
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import com.example.demo.web.TestBeanController
import com.example.demo.service.HelloBean

@SpringBootTest(classes = [TestBeanController])
@AutoConfigureMockMvc
class TestBeanControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestBeanController testBeanController;

    def setup() {
        // MockMvcの初期化
        mockMvc = MockMvcBuilders.standaloneSetup(new TestBeanController()).build()
    }

    def "''へのリクエストでOKが返ってくる"() {
        when:
        def result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/")).andReturn().getResponse()
        then:
        result.getStatus() == HttpStatus.OK.value()
    }

//    def "/bean1でbean1が返ってくる"(){
//        setup:
//
//        when:
//        then:
//    }
}
