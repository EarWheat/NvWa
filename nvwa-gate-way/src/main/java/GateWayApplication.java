import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * @author ：liuzhaolu
 * @description：Ribbon
 * @prd :
 * @date ：2021/12/21 4:02 下午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/21 4:02 下午     liuzhaolu       firstVersion
 */
@Slf4j
@SpringBootApplication
@ComponentScan(value = "com.nvwa")
@ImportResource(locations = "classpath:dubboConfig.xml")
@EnableDubbo
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(GateWayApplication.class);
        application.run(args);
        log.info("GateWayApplication started");
    }
}
