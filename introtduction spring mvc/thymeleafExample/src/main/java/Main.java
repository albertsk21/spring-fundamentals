import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.StringWriter;

public class Main {

    public static void main(String[] args){


        ITemplateEngine iTemplateEngine = initEngine();

        Context context = new Context();
        context.setVariable("name","John");
        StringWriter stringWriter = new StringWriter();
        iTemplateEngine.process("test.html",context,stringWriter);
        System.out.println(stringWriter);
    }


    private static ITemplateEngine initEngine(){
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());

        return templateEngine;
    }
}
