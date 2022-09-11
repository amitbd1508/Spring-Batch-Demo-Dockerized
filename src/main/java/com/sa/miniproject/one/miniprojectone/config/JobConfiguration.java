package com.sa.miniproject.one.miniprojectone.config;

import com.sa.miniproject.one.miniprojectone.batch.DbProcessor;
import com.sa.miniproject.one.miniprojectone.batch.DbWriter;
import com.sa.miniproject.one.miniprojectone.dto.StudentDto;
import com.sa.miniproject.one.miniprojectone.entity.Student;
import com.sa.miniproject.one.miniprojectone.mapper.StudentFieldSetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final DbWriter dbWriter;
  private final DbProcessor dbProcessor;

  @Bean
  public FlatFileItemReader<StudentDto> personItemReader() {
    FlatFileItemReader<StudentDto> reader = new FlatFileItemReader<>();
    reader.setLinesToSkip(1);
    reader.setResource(new ClassPathResource("/data/person.csv"));

    DefaultLineMapper<StudentDto> customerLineMapper = new DefaultLineMapper<>();

    DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
    tokenizer.setNames("id", "firstname", "lastname", "gpa", "age");

    customerLineMapper.setLineTokenizer(tokenizer);
    customerLineMapper.setFieldSetMapper(new StudentFieldSetMapper());
    customerLineMapper.afterPropertiesSet();
    reader.setLineMapper(customerLineMapper);
    return reader;
  }

  @Bean
  public Step processCSVStep() {
    return stepBuilderFactory
      .get("processCSVStep")
      .<StudentDto, Student>chunk(10)
      .reader(personItemReader())
      .processor(dbProcessor)
      .writer(dbWriter)
      .build();
  }

  @Bean
  public Job job() {
    return jobBuilderFactory.get("job")
      .start(processCSVStep())
      .build();
  }
}
