import com.nvwa.registry.annotation.EnableRegistryServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ：liuzhaolu
 * @description：eureka
 * @prd :
 * @date ：2021/12/21 11:30 上午
 * @Modification Date         Author          Description
 * ------------------------------------------ *
 * 2021/12/21 11:30 上午     liuzhaolu       firstVersion
 */
@Slf4j
@SpringBootApplication
//@EnableEurekaServer
@EnableRegistryServer
@ComponentScan(value = "com.nvwa")
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication eurekaServiceApplication = new SpringApplication(EurekaServiceApplication.class);
        eurekaServiceApplication.run(args);
        log.info("EurekaServiceApplication started");
    }
}
