package com.example.app.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Scheduling {
	
//	@Scheduled(fixedRate = 1000)
//	public void t1() {
//		System.out.println("Scheduling's t1 invoke..."+ new Date());
//	}
	
//	@Scheduled(cron = "0/2 * * * * *")
//	public void t2() {
//		System.out.println("Scheduling's t2 invoke..."+ new Date());
//	}
}
