package main;

import assembler.Assembler;
import dao.MemberInfoPrinter;
import dao.MemberListPrinter;
import dao.VersionPrinter;
import domain.RegisterRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import service.ChangePasswordService;
import service.MemberRegisterService;
import validation.AlreadyExistingMemberException;
import validation.MemberNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {
    private static ApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("명령어를 입력하세요");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }

            if (command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("change ")) {
                processNewCommand(command.split(" "));
                continue;
            } else if (command.startsWith("list")) {
                processListCommand();
                continue;
            } else if (command.startsWith("info ")) {
                processInfoCommand(command.split(" "));
                continue;
            } else if (command.startsWith("version")) {
                processVersionCommand();
                continue;
            }
            printHelp();
        }
    }

    private static Assembler assembler = new Assembler();

    private static void processNewCommand(String [] args) {
        if (args.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(args[1]);
        req.setName(args[2]);
        req.setPassword(args[3]);
        req.setConfirmPassword(args[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하지 않습니다.");
            return;
        }

        try {
            regSvc.regist(req);
            System.out.println("등록했습니다. \n");
        } catch (AlreadyExistingMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.");
        }
    }

    private static void processChangeCommand(String [] args) {
        if (args.length != 4) {
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);

        try {
            changePwdSvc.changePassword(args[1], args[2], args[3]);
            System.out.println("암호를 변경했습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }
    }

    private static void processListCommand() {
        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void processInfoCommand(String [] args) {
        if (args.length != 2) {
            printHelp();
            return;
        }
        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(args[1]);
    }

    private static void processVersionCommand() {
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
        System.out.println("명령어 사용법:");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
}
