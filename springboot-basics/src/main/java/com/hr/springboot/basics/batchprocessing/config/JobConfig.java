package com.hr.springboot.basics.batchprocessing.config;

import com.hr.springboot.basics.batchprocessing.entity.Customer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<Customer> reader;

    @Autowired
    private ItemWriter<Customer> writer;
    @Autowired
    private ItemProcessor<Customer, Customer> processor;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Customer, Customer>chunk(5)
                .reader(reader)
                .writer(writer)
                .processor(processor).build();
    }

    @Bean
    public Job notificationJob() {
        return jobBuilderFactory.get("Notification Job")
                .flow(step1())
                .end().build();
    }

}
