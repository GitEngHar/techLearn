package conf
import spock.lang.Specification
import com.example.demo.conf.AppConfig

class AppConfigSpec extends Specification {
    AppConfig sut
    def setup(){
        sut = new AppConfig()
    }
    def "bean1,bean2 を生成できる"(){
        when:
        def result_bean1 = sut.bean1()
        def result_bean2 = sut.bean2()
        then:
        result_bean1 == "Bean1"
        result_bean2 == "Bean2"
    }
}
