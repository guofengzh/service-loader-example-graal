package sukumaar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class SpringBootLoaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootLoaderApplication.class, args);
    }
}
