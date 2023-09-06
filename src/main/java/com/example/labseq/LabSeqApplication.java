package com.example.labseq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LabSeqApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSeqApplication.class, args);
    }

}
