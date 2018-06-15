import assembler.Assembler;
import dao.MemberDao;
import domain.Member;
import org.springframework.context.support.GenericXmlApplicationContext;
import service.ChangePasswordService;
import service.MemberRegisterService;

public class Main {
    public static void main(String[] args) {
        Assembler assembler = new Assembler();
        ChangePasswordService changePasswordService = assembler.getPwdSvc();
        MemberRegisterService memberRegisterService = assembler.getRegSvc();
        // regSvc pwdSvc를 사용하는 코드
    }
}
