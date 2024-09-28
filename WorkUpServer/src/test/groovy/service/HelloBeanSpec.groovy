package service

import com.example.demo.service.HelloBean
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.ReflectionTestUtils
import spock.lang.Specification

@SpringBootTest
class HelloBeanSpec extends Specification {
    HelloBean sut;

    def setup(){
        sut = new HelloBean()
    }

    def "property hogehogeの値を取得できる"(){
        setup:
        ReflectionTestUtils.setField(sut, "beanTestValue", "hogehoge")
        when:
        def result = sut.confirmBeanTestValue()
        then:
        result == "hogehoge"
    }
}
