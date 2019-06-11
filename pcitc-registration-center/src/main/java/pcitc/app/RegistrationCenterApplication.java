package pcitc.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author zhf
 * 2017-11-16
 * 服务注册中心启动类
 * Integrated management platform for science and technology
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationCenterApplication {


	public static void main(String[] args) {
		SpringApplication.run(RegistrationCenterApplication.class, args);
	}
}
