package com.example.component.jobs;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springside.modules.utils.time.ClockUtil;

/**
 * 定时任务 (暂时未解决在启动过程中任务运行)
 * 在旧项目中有xml配置延时启动
 * @author woshizbh
 *
 */
@Configuration
@EnableScheduling
public class TaskJob {
	@Scheduled(cron = "0 0/10 * * * ?")
	public void job1() {
		System.out.println("--定时任务启动了-- "+ClockUtil.currentDate());
	}
}
