package com.sa.miniproject.one.miniprojectone.config;

import com.sa.miniproject.one.miniprojectone.batch.DbProcessor;
import com.sa.miniproject.one.miniprojectone.batch.DbWriter;
import com.sa.miniproject.one.miniprojectone.mapper.PersonFieldSetMapper;
import com.sa.miniproject.one.miniprojectone.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
@RequiredArgsConstructor
public class JobConfiguration {

  private final JobBuilderFactory jobBuilderFactory;
  private final StepBuilderFactory stepBuilderFactory;
  private final DbWriter dbWriter;
  private final DbProcessor dbProcessor;

  @Bean
  public FlatFileItemReader<Person> personItemReader() {
    FlatFileItemReader<Person> reader = new FlatFileItemReader<>();
    reader.setLinesToSkip(1);
    reader.setResource(new ClassPathResource("/data/person.csv"));

    DefaultLineMapper<Person> customerLineMapper = new DefaultLineMapper<>();

    DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
    tokenizer.setNames("id", "firstname", "lastname", "gpa", "age");

    customerLineMapper.setLineTokenizer(tokenizer);
    customerLineMapper.setFieldSetMapper(new PersonFieldSetMapper());
    customerLineMapper.afterPropertiesSet();
    reader.setLineMapper(customerLineMapper);
    return reader;
  }

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1")
      .<Person, Person>chunk(10)
      .reader(personItemReader())
      .processor(dbProcessor)
      .writer(dbWriter)
      .build();
  }

  @Bean
  public Job job() {
    return jobBuilderFactory.get("job")
      .start(step1())
      .build();
  }
}
