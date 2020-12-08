package com.i2finance.bank;

import com.i2finance.bank.util.SimpleJpaRepositoryImpl;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(value = "com.i2finance.bank.dao", repositoryBaseClass = SimpleJpaRepositoryImpl.class)
@SpringBootApplication
@EnableSwagger2Doc   //开启swagger
public class BankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

}
