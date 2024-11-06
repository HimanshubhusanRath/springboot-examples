package com.hr.springboot.basics.batchprocessing.config;

import com.hr.springboot.basics.batchprocessing.entity.Customer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BatchConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Bean
    public MongoItemReader<Customer> reader() {
        MongoItemReader<Customer> reader = new MongoItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setQuery("{}");
        reader.setTargetType(Customer.class);
        // To sort the values by customer Id (desc)
        reader.setSort(new HashMap<String, Sort.Direction>() {
            {
                put("_customerId", Sort.Direction.DESC);
            }
        });
        return reader;
    }

    @Bean
    public StaxEventItemWriter<Customer> writer() {
        final StaxEventItemWriter<Customer> writer = new StaxEventItemWriter<>();
        writer.setRootTagName("customers");
        writer.setResource(new FileSystemResource("xml/customers.xml"));
        writer.setMarshaller(getMarshaller());
        return writer;
    }

    private Marshaller getMarshaller() {
        final XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAliases(Map.of("customer", Customer.class));
        return marshaller;
    }

    @Bean
    public ItemProcessor<Customer, Customer> processor() {
        final ItemProcessor<Customer, Customer> processor = new ItemProcessor<Customer, Customer>() {
            @Override
            public Customer process(Customer customer) throws Exception {
                if (customer.getAge() < 18) {
                    System.out.println(String.format("%s is not an adult.",customer.getName()));
                }
                return customer;
            }

            private String getContent(final Customer customer) {
                return String.format("The customer %s is not an adult", customer.getName());
            }

        };
        return processor;
    }
}
