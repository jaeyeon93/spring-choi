import assembler.Assembler;
import dao.MemberDao;
import domain.Member;
import org.springframework.context.support.GenericXmlApplicationContext;
import service.ChangePasswordService;
import service.MemberRegisterService;

public class Main {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
        Client client = ctx.getBean("client", Client.class);
        Client client2 = ctx.getBean("client", Client.class);
        System.out.println("client == client2 : " + client.equals(client2));
        client.send();
        ctx.close();
    }
}
