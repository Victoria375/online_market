package com.spring.market.online_market.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackages = "com.spring.market.online_market.entities")
//@EnableJpaRepositories(basePackages = "com.spring.market.online_market.repositories")
public class OnlineMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketApplication.class, args);
	}

}
