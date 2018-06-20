import domain.Greeter;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
        Greeter g = ctx.getBean("greeter", Greeter.class);
        String result = g.input("Hello world");
        System.out.println(result);
    }
}
