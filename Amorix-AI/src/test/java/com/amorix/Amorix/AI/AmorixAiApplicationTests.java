package com.amorix.Amorix.AI;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AmorixAiApplicationTests {

	@Test
	void contextLoads() {
	}
	@Value("${stripe.webhook.secret}")
	@PostConstruct
	public void test() {
		System.out.println("Webhook Secret = " + webhookSecret);
	}

}
