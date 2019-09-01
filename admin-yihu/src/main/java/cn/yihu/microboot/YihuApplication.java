package cn.yihu.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class YihuApplication {

	public static void main(String[] args) {
		SpringApplication.run(YihuApplication.class, args);
	}

}
