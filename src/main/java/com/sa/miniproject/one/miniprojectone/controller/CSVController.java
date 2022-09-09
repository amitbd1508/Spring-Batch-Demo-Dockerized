package com.sa.miniproject.one.miniprojectone.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/processcsv")
@RequiredArgsConstructor
public class CSVController {
  private final JobLauncher jobLauncher;

  private final Job job;

  @GetMapping()
  private BatchStatus processCSV() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    JobParameters jobParameters = new JobParametersBuilder()
      .addString("date", UUID.randomUUID().toString())
      .addLong("JobId",System.currentTimeMillis())
      .addLong("time",System.currentTimeMillis()).toJobParameters();

    JobExecution execution = jobLauncher.run(job, jobParameters);
    System.out.println("STATUS :: "+execution.getStatus());
    return  execution.getStatus();
  }
}
