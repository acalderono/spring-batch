package com.ait.batch.tasks;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunScheduler {
	
	private static final Logger LOG = LoggerFactory.getLogger(RunScheduler.class);

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;

	@Scheduled(fixedRate = 10000)
	public void run()  {
		
		try {
			
			String dateParam = new Date().toString();
			JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
			LOG.info("Inicio del JOB {}", dateParam);
			JobExecution execution = jobLauncher.run(job, param);
			LOG.info("Exit Status: {}", execution.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
}
