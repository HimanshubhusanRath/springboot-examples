package com.hr.springboot.basics;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableAsync
@EnableCaching
@EnableScheduling
@EnableBatchProcessing
public class SpringbootBasicsApplication {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBasicsApplication.class, args);
    }

//    @PostConstruct
//    public void loadData() {
//        final List<Customer> customers = List.of(
//                new Customer(1L, "A", 21, "city-1"),
//                new Customer(2L, "B", 22, "city-2"),
//                new Customer(3L, "C", 23, "city-3"),
//                new Customer(4L, "D", 24, "city-4"),
//                new Customer(5L, "E", 25, "city-5"),
//                new Customer(6L, "F", 26, "city-6"),
//                new Customer(7L, "G", 27, "city-7"),
//                new Customer(8L, "H", 28, "city-8"),
//                new Customer(9L, "I", 29, "city-9")
//		);
//        mongoTemplate.insertAll(customers);
//    }
}
