package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingletonTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A사용자의 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        // ThreadB : B사용자의 20000원 주문
        int userBprice = statefulService2.order("userB", 20000);

        // ThreadA : 사용자 A 주문 금액 확인
        // int price = statefulService1.order();
        System.out.println("price = " + userAprice);

        //assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefullService(){
            return new StatefulService();
        }
    }
}