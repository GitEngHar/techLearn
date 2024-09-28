package com.example.demo.service.gametransaction

import com.example.demo.repository.gametransaction.GamePointRepository
import com.example.demo.repository.gametransaction.TransactionalRepository
import org.spockframework.spring.SpringBean
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@SpringBootTest
class TransactionalServiceSpeck extends Specification {
    @SpringBean
    TransactionalRepository transactionalRepository = Mock()

    @SpringBean
    GamePointRepository gamePointRepository = Mock()

    @Subject
    TransactionalService transactionalService

    def setup(){
        this.transactionalService = new TransactionalService(transactionalRepository,gamePointRepository)
    }

    @Unroll
    def "itemの在庫を減算できる" (){
        when:
        transactionalService.minusItemStock(itemId)
        then:
        transactionalService.getBreadStock() == breadStockResult
        transactionalService.getAppleStock() == appleStockResult
        where:
        itemId || breadStockResult || appleStockResult
        1 || 1 || 2
        2 || 2 || 1
    }

    @Unroll
    def "itemの在庫以上を交換するとExceptionが発生する" (){
        when:
        transactionalService.setBreadStock(0)
        transactionalService.minusItemStock(1)
        then:
        thrown(Exception)
    }

}
