package org.mengsoft.webbackend;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.mengsoft.webbackend.dao")
public class WebbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebbackendApplication.class, args);
    }

}
