package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        OrderService orderService = new OrderServiceImpl();
//        MemberService memberService = new MemberServiceImpl();

//        AppConfig appConfig = new AppConfig();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itmeA", 20000);

        System.out.println("order = " + order);
        System.out.println("orderCalculatePrice = " + order.calculatePrice());

    }

}