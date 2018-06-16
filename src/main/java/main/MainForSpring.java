package main;

import assembler.Assembler;
import config.JavaConfig;
import dao.MemberInfoPrinter;
import dao.MemberListPrinter;
import dao.VersionPrinter;
import domain.RegisterRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import service.ChangePasswordService;
import service.MemberRegisterService;
import validation.AlreadyExistingMemberException;
import validation.MemberNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);

        RegisterRequest regReq = new RegisterRequest();
        regReq.setEmail("jaeyeon93@naver.com");
        regReq.setName("김재연");
        regReq.setPassword("12345");
        regReq.setConfirmPassword("12345");
        regSvc.regist(regReq);

        infoPrinter.printMemberInfo("jaeyeon93@naver.com");
    }
}
