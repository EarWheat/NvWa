import com.nvwa.remote.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：liuzhaolu
 * @description：engine启动类
 * @prd :
 * @date ：2022/1/12 4:50 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2022/1/12 4:50 下午     liuzhaolu       firstVersion
 */
@SpringBootApplication
@Slf4j
@ComponentScan(value = "com.nvwa")
//@ImportResource(locations = "classpath:dubboConfig.xml")
//@EnableDubbo
public class EngineApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EngineApplication.class);
        ConfigurableApplicationContext context = application.run(args);
        HelloService helloService = (HelloService) context.getBean("HelloService");
        System.out.println(helloService.sayHello());
        log.info("nvwa engine start success");
    }
}
