package dao;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class MemberInfoPrinter {
    @Autowired
    private MemberDao memberDao;
    private MemberPrinter printer;

    public MemberInfoPrinter() {}

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        System.out.println("MemberInfoPrinter 주입 : " + memberDao);
        this.memberDao = memberDao;
    }

    @Autowired
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터없음");
            return;
        }
        printer.print(member);
        System.out.println();
    }
}
