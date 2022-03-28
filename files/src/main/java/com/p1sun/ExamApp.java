
package com.p1sun;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.p1sun")
public class ExamApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ExamApp.class, args);
    }

}
