package br.com.hiddn.hiddnserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.hiddn.hiddnserver.repository")
public class HiddnServer extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(HiddnServer.class, args);
	}
}