package com.capg.springbootbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.capg.springbootbatch.model.Employee;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

	@Value("${file.input}")
	public String uploadDirectory;

	@Bean
	public Job job(JobBuilderFactory jobfactory, StepBuilderFactory stepfactory, ItemReader<Employee> itemReader,
			ItemProcessor<Employee, Employee> itemProccessor, ItemWriter<Employee> itemWriter) {

		Step step = stepfactory.get("DemoBatchFileLoad").<Employee, Employee>chunk(100).reader(itemReader)
				.processor(itemProccessor)
				.writer(itemWriter).build();

		Job job = jobfactory.get("DemoBatch").incrementer(new RunIdIncrementer()).start(step).build();
		return job;

	}

	@Bean
	public FlatFileItemReader<Employee> employeeReader(@Value("${file.input}") Resource resource) {
		FlatFileItemReader<Employee> flatFileItemReader = new FlatFileItemReader<Employee>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());

		return flatFileItemReader;

	}

	public LineMapper<Employee> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<Employee> defaultLineMapper = new DefaultLineMapper<Employee>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "employeeId", "firstName", "lastName", "email" });
		BeanWrapperFieldSetMapper<Employee> fieldSetMapper = new BeanWrapperFieldSetMapper<Employee>();
		fieldSetMapper.setTargetType(Employee.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}

}